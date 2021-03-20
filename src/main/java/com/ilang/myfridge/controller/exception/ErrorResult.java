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

  // todo 여기 builder 넣으면 ErrorResponse에 safe delete하라고 뜨는 이유?
  //  @Builder
  public void ErrorResponse(int code, HttpStatus status, String message) {
    this.timestamp = LocalDateTime.now();
    this.code = code;
    this.status = status;
    this.message = message;
  }
}
