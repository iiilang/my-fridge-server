package com.ilang.myfridge.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResult> notFoundException(NotFoundException e) {

    ErrorResult er = ErrorResult.of(e.getCode(), HttpStatus.NOT_FOUND, e.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
  }
}
