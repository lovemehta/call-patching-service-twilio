package com.nutripal.cps.twilio;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import com.nutripal.cps.exceptions.CallException;
import com.twilio.http.HttpMethod;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.type.PhoneNumber;

public class TwilioLine {
  private String twilioNumber;
  private TwilioRestClient restClient;

  public TwilioLine(TwilioRestClient restClient, String twilioNumber) {
    this.restClient = restClient;
    this.twilioNumber = twilioNumber;
  }

  public Call call(final String phoneNumber, final String responseUrl, final Boolean record,
      final String recordCallbackUrl, final String callDataCallbackUrl) {
    try {
      CallCreator callCreator = new CallCreator(new PhoneNumber(phoneNumber),
          new PhoneNumber(twilioNumber), new URI(responseUrl));
      if (Boolean.TRUE.equals(record)) {
        callCreator.setRecord(record);
        callCreator.setRecordingChannels("mono");
        callCreator.setRecordingStatusCallback(recordCallbackUrl);
        callCreator
            .setRecordingStatusCallbackEvent(Arrays.asList("in-progress", "completed", "absent"));
      }

      callCreator.setStatusCallback(callDataCallbackUrl);
      callCreator.setStatusCallbackMethod(HttpMethod.POST).setRecordingStatusCallbackEvent(
          Arrays.asList("initiated", "ringing", "answered", "completed"));
      return callCreator.create(restClient);
    } catch (URISyntaxException e) {
      throw new CallException(e);
    }
  }
}
