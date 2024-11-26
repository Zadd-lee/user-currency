package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CreateExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService service;
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> create(@Valid @RequestBody CreateExchangeRequestDto dto) {
        ExchangeResponseDto responseDto = service.create(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
