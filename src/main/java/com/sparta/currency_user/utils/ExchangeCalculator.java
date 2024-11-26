package com.sparta.currency_user.utils;

import java.math.BigDecimal;

public class ExchangeCalculator {
    public static BigDecimal calculateInt(Integer originalMoney, BigDecimal rate ) {
        return BigDecimal.valueOf(originalMoney).divide(rate,2,BigDecimal.ROUND_HALF_UP);
    }
}
