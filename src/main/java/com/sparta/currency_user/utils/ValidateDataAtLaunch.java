package com.sparta.currency_user.utils;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 스프링이 구동되는 시점에
 * Currency 테이블의 데이터가
 * 정상적인 값을 가지는지 확인
 */
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
