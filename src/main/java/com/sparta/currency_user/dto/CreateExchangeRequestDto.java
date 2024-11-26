package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateExchangeRequestDto {

    @NotNull
    private Long user_id;

    @NotNull
    private Long currency_id;

    @NotNull
    @Positive
    private int amount_in_krw;

}
