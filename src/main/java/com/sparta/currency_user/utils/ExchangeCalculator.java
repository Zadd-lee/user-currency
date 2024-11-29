package com.sparta.currency_user.utils;

import com.sparta.currency_user.constant.DigitByCurrency;
import com.sparta.currency_user.entity.Currency;

import java.math.BigDecimal;

public class ExchangeCalculator {

    /**
     * 정수 타입의 돈과 환율 정보값을 이용해
     * 환전 후 금액을 계산해주는 기능
     * @param originalMoney
     * @param currency
     * @return result
     */
    public static BigDecimal calculateInt(Integer originalMoney, Currency currency) {
        DigitByCurrency digitByCurrency = DigitByCurrency.valueOf(currency.getCurrencyName());
        return BigDecimal.valueOf(originalMoney).divide(currency.getExchangeRate(), digitByCurrency.getDigit(), BigDecimal.ROUND_HALF_UP);
    }

}
