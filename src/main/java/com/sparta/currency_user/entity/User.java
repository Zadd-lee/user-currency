package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Exchange> exchangeList = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {}
}