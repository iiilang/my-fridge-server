package com.ilang.myfridge.controller.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotFoundException extends NullPointerException {
  private final String code;
  private final String message;

  public static NotFoundException of(ErrorCode errorCode) {
    return new NotFoundException(errorCode.getErrorCode(), errorCode.getErrorMessage());
  }
}
