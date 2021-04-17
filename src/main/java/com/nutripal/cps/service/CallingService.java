package com.nutripal.cps.service;

import com.nutripal.cps.enums.TwilioNumberType;

public interface CallingService {

  String tryToCallTwilioUsing(String userPhone, String nutripalPOCPhone,
      TwilioNumberType twilioNumberType, Boolean record, String webhookUrl);

}
