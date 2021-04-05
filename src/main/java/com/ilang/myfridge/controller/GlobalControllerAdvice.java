package com.ilang.myfridge.controller;

import com.ilang.myfridge.controller.exception.ErrorResult;
import com.ilang.myfridge.controller.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResult> notFoundException(NotFoundException e) {

    ErrorResult er = ErrorResult.of(e.getCode(), HttpStatus.NOT_FOUND, e.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
  }
}
