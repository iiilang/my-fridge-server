package com.ilang.myfridge.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

// todo @Getter로 어떻게 접근?
@Getter
@NoArgsConstructor
public class ErrorResult {
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime timestamp;

  private int code;
  private HttpStatus status;
  private String message;

  private ErrorResult(int code, HttpStatus status, String message) {
    this.timestamp = LocalDateTime.now();
    this.code = code;
    this.status = status;
    this.message = message;
  }

  public static ErrorResult of(int code, HttpStatus status, String message) {
    return new ErrorResult(code, status, message);
  }
}
