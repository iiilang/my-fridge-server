package com.ilang.myfridge.controller.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends NullPointerException {
  private int code;
  private String message;

  public NotFoundException(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
