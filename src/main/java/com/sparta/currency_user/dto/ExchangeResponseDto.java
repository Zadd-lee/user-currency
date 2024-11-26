package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class ExchangeResponseDto  {

    private Long exchangeId;
    private Long userId;
    private Long currencyId;
    private Integer amountInKrw;
    private Float amountAfterExchange;
    private String status;
    private Timestamp modifiedAt;

    public ExchangeResponseDto(Exchange exchange) {
        this.exchangeId = exchange.getId();
        this.userId = exchange.getUser().getId();
        this.currencyId = exchange.getCurrency().getId();
        this.amountInKrw = exchange.getAmountInKRW();
        this.amountAfterExchange = exchange.getAmountAfterExchange();
        this.status = exchange.getStatus();
        this.modifiedAt = exchange.getModifiedAt();
    }
}
