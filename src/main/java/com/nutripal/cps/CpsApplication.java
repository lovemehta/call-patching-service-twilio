package com.nutripal.cps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.nutripal.cps.twilio.TwilioLine;
import com.nutripal.cps.twilio.TwilioRequestValidator;
import com.twilio.http.TwilioRestClient;
import com.twilio.security.RequestValidator;

@SpringBootApplication
public class CpsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CpsApplication.class, args);
  }

  @Bean
  public TwilioRestClient twilioRestClient(@Value("${TWILIO_ACCOUNT_SID}") String accountSid,
      @Value("${TWILIO_AUTH_TOKEN}") String authToken) {
    return new TwilioRestClient.Builder(accountSid, authToken).build();
  }


  @Bean
  public TwilioRequestValidator twilioRequestValidator(
      @Value("${TWILIO_AUTH_TOKEN}") String authToken) {
    return new TwilioRequestValidator(new RequestValidator(authToken));
  }

  @Bean("twilioLineNutritionistNumber")
  public TwilioLine twilioLineNutritionistNumber(TwilioRestClient restClient,
      @Value("${TWILIO_NUTRITIONIST_NUMBER}") String twilioNumber) {
    return new TwilioLine(restClient, twilioNumber);
  }

  @Bean("twilioLineCrmNumber")
  public TwilioLine twilioLineCrmNumber(TwilioRestClient restClient,
      @Value("${TWILIO_CRM_NUMBER}") String twilioNumber) {
    return new TwilioLine(restClient, twilioNumber);
  }

}
