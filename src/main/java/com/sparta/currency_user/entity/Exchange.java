package com.sparta.currency_user.entity;

import com.sparta.currency_user.constant.Status;
import com.sparta.currency_user.utils.ExchangeCalculator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        this.status = Status.USE.getStatus();
    }

    public void updateAmount(Integer amountInKRW) {
        this.amountInKRW = amountInKRW;
        //한화와 환율 정보값을 이용해 환전후 금액을 계산
        this.amountAfterExchange = ExchangeCalculator.calculateInt(amountInKRW, currency).floatValue();
    }

    public void updateStatus(Status status) {
        this.status = status.getStatus();
    }

}
