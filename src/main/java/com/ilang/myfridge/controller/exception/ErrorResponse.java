package com.ilang.myfridge.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp;

  private String code;
  private String message;

  private ErrorResponse(String code, String message) {
    this.timestamp = LocalDateTime.now();
    this.code = code;
    this.message = message;
  }

  public static ErrorResponse of(String code, String message) {
    return new ErrorResponse(code, message);
  }
}

