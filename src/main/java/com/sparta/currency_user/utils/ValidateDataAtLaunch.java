package com.sparta.currency_user.utils;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ValidateDataAtLaunch {
    private final CurrencyRepository currencyRepository;

    @PostConstruct
    public void validateCurrency() {
        List<Currency> all = currencyRepository.findAll();
        for (Currency currency : all) {
            if (currency.getExchangeRate().signum() == -1) {
                log.warn("검증 오류 - {}/{} : 음수 값", currency.getClass().getSimpleName(), currency.getCurrencyName());
            }
        }
    }
}
