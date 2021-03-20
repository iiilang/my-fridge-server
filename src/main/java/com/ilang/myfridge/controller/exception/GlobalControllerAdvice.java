package com.ilang.myfridge.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResult> notFoundExcpetion(NotFoundException e) {

    ErrorResult er = new ErrorResult();
    // 1번
    er.ErrorResponse(e.getCode(), HttpStatus.NOT_FOUND, e.getMessage());
    // 2번
    // er.builder().code(e.getCode()).status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
  }
}
