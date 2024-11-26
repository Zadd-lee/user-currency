package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExchangeErrorCode implements ErrorCode {
    INV(HttpStatus.BAD_REQUEST, "잘못된 요청"),
    NOT_FOUND(HttpStatus.NOT_FOUND,"환전 기록을 찾을 수 없습니다")
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
