package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateExchangeRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long currencyId;

    @NotNull
    @Positive
    private int amountInKrw;

}
