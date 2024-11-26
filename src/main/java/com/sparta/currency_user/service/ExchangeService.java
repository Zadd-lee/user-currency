package com.sparta.currency_user.service;

import com.sparta.currency_user.constant.CurrencyErrorCode;
import com.sparta.currency_user.constant.UserErrorCode;
import com.sparta.currency_user.dto.CreateExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.exception.RestApiException;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public ExchangeResponseDto create(CreateExchangeRequestDto dto) {
        Optional<Currency> currency = currencyRepository.findById(dto.getCurrency_id());
        if (currency.isEmpty()) {
            throw new RestApiException(CurrencyErrorCode.NOT_FOUND);
        }

        Optional<User> user = userRepository.findById(dto.getUser_id());
        if(user.isEmpty()) {
            throw new RestApiException(UserErrorCode.NOT_FOUND);
        }

        Exchange exchange = new Exchange(currency.get(),user.get());
        exchange.updateAmount(dto.getAmount_in_krw());


        Exchange savedExchage = exchangeRepository.save(exchange);
        return new ExchangeResponseDto(savedExchage);

    }
}
