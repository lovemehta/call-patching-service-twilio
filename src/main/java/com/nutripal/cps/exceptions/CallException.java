package com.nutripal.cps.exceptions;

public class CallException extends RuntimeException {

  public CallException(Throwable e) {
    super(e);
  }
}
