package com.ilang.myfridge.controller;

import com.ilang.myfridge.controller.exception.ErrorCode;
import com.ilang.myfridge.controller.exception.ErrorResponse;
import com.ilang.myfridge.controller.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

<<<<<<< HEAD
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {

    ErrorResponse er = ErrorResponse.of(e.getCode(), e.getMessage());

    return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {

    ErrorResponse er =
        ErrorResponse.of(
            ErrorCode.INVALID_INPUT_VALUE.getErrorCode(),
            ErrorCode.INVALID_INPUT_VALUE.getErrorMessage());

    return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {

    ErrorResponse er =
        ErrorResponse.of(
            ErrorCode.JSON_PARSE_ERROR.getErrorCode(),
            ErrorCode.JSON_PARSE_ERROR.getErrorMessage());

    return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
  }
}
=======
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {

        ErrorResponse er = ErrorResponse.of(e.getCode(), e.getMessage());

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        ErrorResponse er =
                ErrorResponse.of(
                        ErrorCode.INVALID_INPUT_VALUE.getErrorCode(),
                        ErrorCode.INVALID_INPUT_VALUE.getErrorMessage());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {

        ErrorResponse er =
                ErrorResponse.of(
                        ErrorCode.JSON_PARSE_ERROR.getErrorCode(),
                        ErrorCode.JSON_PARSE_ERROR.getErrorMessage());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}

>>>>>>> 59969b0cca0ae45f3aee0235e2e63fa25fe32057
