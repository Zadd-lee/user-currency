package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Exchange extends  TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_id")
    private Long id;
    private Integer amountInKRW;
    private Float amountAfterExchange;
    private String status;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Exchange(Currency currency, User user) {
        this.currency = currency;
        this.user = user;
    }

    public void updateAmount(Integer amountInKRW) {
        this.amountInKRW = amountInKRW;

        BigDecimal exchangeRate = currency.getExchangeRate();
        calculateAfterExchage(exchangeRate);
    }

    private void calculateAfterExchage(BigDecimal exchangeRate) {

    }

}
