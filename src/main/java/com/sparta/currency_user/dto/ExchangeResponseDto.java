package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class ExchangeResponseDto  {

    private Long exchange_id;
    private Long user_id;
    private Long currency_id;
    private Integer amount_in_krw;
    private Float amount_after_exchange;
    private String status;
    private Timestamp modified_at;

    public ExchangeResponseDto(Exchange exchange) {
        this.exchange_id = exchange.getId();
        this.user_id = exchange.getUser().getId();
        this.currency_id = exchange.getCurrency().getId();
        this.amount_in_krw = exchange.getAmountInKRW();
        this.amount_after_exchange = exchange.getAmountAfterExchange();
        this.status = exchange.getStatus();
        this.modified_at = exchange.getModifiedAt();
    }
}
