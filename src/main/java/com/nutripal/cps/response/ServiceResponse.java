package com.nutripal.cps.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.ToString;

@ToString(callSuper = true, includeFieldNames = true)
public class ServiceResponse<T extends BaseResponse> extends ResponseEntity<T> {

  public ServiceResponse(T data) {
    super(data, HttpStatus.OK);
  }

  public ServiceResponse(T data, HttpStatus statusCode) {
    super(data, statusCode);
  }

}
