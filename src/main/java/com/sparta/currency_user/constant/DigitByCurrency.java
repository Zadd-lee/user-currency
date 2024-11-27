package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DigitByCurrency {
    USD(2),
    JPY(0),;
    private final int Digit;
}
