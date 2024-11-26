package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Exchange extends  TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_id")
    private Long id;
    private Integer amountInKRW;
    private Float amountAfterExchange;
    private String status;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.REMOVE)
    List<Currency> currencies = new ArrayList<>();

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.REMOVE)
    List<User> users = new ArrayList<>();
}
