package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExchangeErrorCode {
    INV(HttpStatus.BAD_REQUEST, "잘못된 요청"),;

    private final HttpStatus httpStatus;
    private final String message;
}
