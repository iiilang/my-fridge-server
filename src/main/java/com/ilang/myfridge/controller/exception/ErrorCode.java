package com.ilang.myfridge.controller.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  // Common
  INVALID_INPUT_VALUE("C001", "입력값이 유효하지 않습니다."),
  JSON_PARSE_ERROR("C002", "JSON을 파싱할 수 없습니다."),

  // Fridge
  FRIDGE_NOT_FOUND("RE01", "냉장고를 찾을 수 없습니다."),
<<<<<<< HEAD

  // Food
  FOOD_NOT_FOUND("FO01", "음식을 찾을 수 없습니다."),
  FOOD_NAME_DUPLICATED("FO02", "음식명이 중복됩니다."),
  TYPE_NOT_MATCH("FO03", "냉장고와 식품의 타입이 맞지 않습니다.");

  private final String errorCode;
  private final String errorMessage;

=======
  FRIDGE_NAME_DUPLICATED("RE02", "냉장고명이 중복됩니다."),

  // Food
  FOOD_NOT_FOUND("FO01", "음식을 찾을 수 없습니다."),
  FOOD_NAME_DUPLICATED("FO02", "음식명이 중복됩니다."),
  TYPE_NOT_MATCH("FO03", "냉장고와 식품의 타입이 맞지 않습니다.");

  private String errorCode;
  private String errorMessage;

>>>>>>> 59969b0cca0ae45f3aee0235e2e63fa25fe32057
  ErrorCode(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
