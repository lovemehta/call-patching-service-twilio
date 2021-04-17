package com.nutripal.cps.response;

import com.nutripal.cps.enums.CpsError;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseObjectResponse<T> extends BaseResponse {
  private T data;

  public BaseObjectResponse() {
    super();
  }

  public BaseObjectResponse(T data) {
    super();
    this.data = data;
  }

  public BaseObjectResponse(CpsError code, String errorMessage, T data) {
    super(code, errorMessage);
    this.data = data;
  }
}
