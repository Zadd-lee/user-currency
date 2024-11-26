package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCode{
    NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다"),


    ;
    private final HttpStatus httpStatus;
    private final String message;
}
