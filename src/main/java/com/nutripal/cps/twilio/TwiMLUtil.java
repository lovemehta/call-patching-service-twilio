package com.nutripal.cps.twilio;

import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Dial;
import com.twilio.twiml.voice.Number;
import com.twilio.twiml.voice.Say;

public class TwiMLUtil {

  public static String buildVoiceResponseAndDial(String say, String toPhone) throws TwiMLException {
    Number number = new Number.Builder(toPhone).build();
    return new VoiceResponse.Builder().say(new Say.Builder(say).build())
        .dial(new Dial.Builder().number(number).build()).build().toXml();
  }
}
