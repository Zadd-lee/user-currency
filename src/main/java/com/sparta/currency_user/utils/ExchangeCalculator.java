package com.sparta.currency_user.utils;

import com.sparta.currency_user.constant.DigitByCurrency;
import com.sparta.currency_user.entity.Currency;

import java.math.BigDecimal;

public class ExchangeCalculator {
    public static BigDecimal calculateInt(Integer originalMoney, Currency currency) {
        DigitByCurrency digitByCurrency = DigitByCurrency.valueOf(currency.getCurrencyName());
        return BigDecimal.valueOf(originalMoney).divide(currency.getExchangeRate(), digitByCurrency.getDigit(), BigDecimal.ROUND_HALF_UP);
    }

}
