package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CurrencyErrorCode implements ErrorCode{
    NOT_FOUND(HttpStatus.NOT_FOUND, "환전 대상 통화를 찾을 수 없습니다"),


    ;
    private final HttpStatus httpStatus;
    private final String message;
}
