package com.ilang.myfridge.controller.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  FRIDGE_NOT_FOUND(1001, "냉장고를 찾을 수 없습니다."),
  FOOD_NOT_FOUND(2001, "음식을 찾을 수 없습니다.");

  private int errorCode;
  private String errorMessage;

  ErrorCode(int errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
