package com.sparta.currency_user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    USE("normal"),
    NOT_USE("cancel");

    private final String status;
}
