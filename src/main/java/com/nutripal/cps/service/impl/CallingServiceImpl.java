package com.nutripal.cps.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.nutripal.cps.entity.CallData;
import com.nutripal.cps.enums.TwilioNumberType;
import com.nutripal.cps.exceptions.CallException;
import com.nutripal.cps.repo.CallDataRepo;
import com.nutripal.cps.service.CallingService;
import com.nutripal.cps.twilio.TwilioLine;
import com.nutripal.cps.utils.BeanUtilsUtil;
import com.twilio.rest.api.v2010.account.Call;

@Service
public class CallingServiceImpl implements CallingService {

  @Value("${APPLICATION_URL}")
  String applicationUrl;

  @Value("${TWILIO_NUTRITIONIST_NUMBER}")
  String twilioNutritionistNumber;

  @Value("${TWILIO_CRM_NUMBER}")
  String twilioCrmNumber;

  @Autowired
  @Qualifier("twilioLineCrmNumber")
  private TwilioLine twilioLineCrmNumber;

  @Autowired
  @Qualifier("twilioLineNutritionistNumber")
  private TwilioLine twilioLineNutritionistNumber;

  private String recordingCallbackUrl;
  private String callDataCallbackUrl;

  @Autowired
  private CallDataRepo callDataRepo;

  @PostConstruct
  private void initialize() {// NOPMD
    recordingCallbackUrl = applicationUrl + "/v1/callback/record";
    callDataCallbackUrl = applicationUrl + "/v1/callback/data";
  }

  @Override
  public String tryToCallTwilioUsing(String userPhone, String nutripalPOCNumber,
      TwilioNumberType fromType, Boolean record, String dataWebhookUrl) {

    String response = "Phone call incoming!";
    if (TwilioNumberType.NUTRITIONIST.equals(fromType)) {
      Call call = twilioLineNutritionistNumber.call(nutripalPOCNumber, getResponseUrl(userPhone),
          record, recordingCallbackUrl, callDataCallbackUrl);
      createCallEntryInDB(call);
    }


    if (TwilioNumberType.CRM.equals(fromType)) {
      Call call = twilioLineCrmNumber.call(nutripalPOCNumber, getResponseUrl(userPhone), record,
          recordingCallbackUrl, callDataCallbackUrl);
      createCallEntryInDB(call);
    }

    return response;
  }

  private void createCallEntryInDB(Call call) {

    CallData callData = new CallData();
    BeanUtilsUtil.copyPropertiesIgnoringNullObject(call, callData);
    callDataRepo.save(callData);

  }

  private String getResponseUrl(String toPhone) {
    try {

      return applicationUrl + "/connect/" + URLEncoder.encode(toPhone, "UTF-8");


    } catch (UnsupportedEncodingException e) {
      throw new CallException(e);
    }
  }


}
