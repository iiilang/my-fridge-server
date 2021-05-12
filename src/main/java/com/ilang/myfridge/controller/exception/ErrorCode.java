package com.ilang.myfridge.controller.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  // Common
  INVALID_INPUT_VALUE("C001", "입력값이 유효하지 않습니다."),
  JSON_PARSE_ERROR("C002", "JSON을 파싱할 수 없습니다."),
  SAME_NAME_ERROR("C003", "중복된 이름을 사용할 수 없습니다."),

  // Fridge
  FRIDGE_NOT_FOUND("RE01", "냉장고를 찾을 수 없습니다."),

  // Food
  FOOD_NOT_FOUND("FO01", "음식을 찾을 수 없습니다.");

  private String errorCode;
  private String errorMessage;

  ErrorCode(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
