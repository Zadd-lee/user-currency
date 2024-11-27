package com.sparta.currency_user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ExchangeGroupsInfoResponseDto {
    int count;
    BigDecimal totalAmountInKrw;

    public ExchangeGroupsInfoResponseDto(Long count, Long totalAmountInKrw) {
        this.count = count.intValue();
        this.totalAmountInKrw = new BigDecimal(totalAmountInKrw);
    }
}
