package com.nutripal.cps.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nutripal.cps.enums.CpsError;
import lombok.Data;

@Data
public class BaseResponse {

  @JsonProperty("error_code")
  private CpsError cpsError;

  @JsonProperty("error_message")
  private String errorMessage;

  public BaseResponse() {
    super();
    this.cpsError = CpsError.NO_ERROR;
    this.errorMessage = "NO ERROR";
  }

  public BaseResponse(CpsError cpsError, String errorMessage) {
    super();
    this.cpsError = cpsError;
    this.errorMessage = errorMessage;
  }

}
