package com.example.HealthDiary.global.error.exception;


import lombok.Getter;

@Getter
public class UserException extends RuntimeException{

    private final ErrorCode errorCode;

    public UserException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
