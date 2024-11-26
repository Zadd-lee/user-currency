package com.sparta.currency_user.service;

import com.sparta.currency_user.constant.CurrencyErrorCode;
import com.sparta.currency_user.constant.ExchangeErrorCode;
import com.sparta.currency_user.constant.Status;
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

import java.util.ArrayList;
import java.util.List;
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

    public List<ExchangeResponseDto> findByUserId(Long userId) {
        //검증
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new RestApiException(UserErrorCode.NOT_FOUND);
        }

        //조회
        List<Exchange> exchangesByUserId = exchangeRepository.findAllByUserId(userId);

        if(exchangesByUserId.isEmpty()) {
            throw new RestApiException(ExchangeErrorCode.NOT_FOUND);
        }

        List<ExchangeResponseDto> dtoList = new ArrayList<>();
        for (Exchange exchange : exchangesByUserId) {
            dtoList.add(new ExchangeResponseDto(exchange));
        }
        return dtoList;
    }

    public ExchangeResponseDto cancel(Long exchangeId) {
        //검증
        Exchange exchange = exchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new RestApiException(ExchangeErrorCode.NOT_FOUND));
        exchange.updateStatus(Status.NOT_USE);

        ExchangeResponseDto dto = new ExchangeResponseDto(exchange);
        return dto;
    }
}
