package com.nutripal.cps.dto;

import com.nutripal.cps.enums.TwilioNumberType;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CallCreationDto {

  @NotNull
  private String to;

  @NotNull
  private TwilioNumberType fromNumberType;

  @NotNull
  private String from;

  private Boolean record;

  private String dataWebhookUrl;

}
