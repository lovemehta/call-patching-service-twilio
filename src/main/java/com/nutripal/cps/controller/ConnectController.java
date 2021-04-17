package com.nutripal.cps.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nutripal.cps.twilio.TwiMLUtil;
import com.twilio.twiml.TwiMLException;

@Controller
public class ConnectController {

  private final static String SAY_MESSAGE = "Hi, connecting your call!";

  // private final TwilioRequestValidator requestValidator;

  // @Autowired
  // public ConnectController(TwilioRequestValidator requestValidator) {
  // this.requestValidator = requestValidator;
  // }

  @RequestMapping(value = "connect/{toPhone}", produces = "application/xml")
  public ResponseEntity<String> connect(@PathVariable String toPhone, HttpServletRequest request)
      throws TwiMLException {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_XML);

    // if (requestValidator.validate(request)) {
    return new ResponseEntity<>(TwiMLUtil.buildVoiceResponseAndDial(SAY_MESSAGE, toPhone),
        httpHeaders, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>("Invalid twilio request", HttpStatus.BAD_REQUEST);
    // }
  }
}
