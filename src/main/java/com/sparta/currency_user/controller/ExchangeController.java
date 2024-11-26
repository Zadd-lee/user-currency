package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CreateExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import com.sparta.currency_user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final UserService userService;


    @PostMapping
    public ResponseEntity<ExchangeResponseDto> create(@Valid @RequestBody CreateExchangeRequestDto dto) {
        ExchangeResponseDto responseDto = exchangeService.create(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExchangeResponseDto>> getAll(@PathVariable Long userId) {
        List<ExchangeResponseDto> responseDtos = exchangeService.findByUserId(userId);
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PatchMapping("/{exchangeId}")
    public ResponseEntity<ExchangeResponseDto> cancel(@PathVariable Long exchangeId) {
        ExchangeResponseDto responseDto = exchangeService.cancel(exchangeId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ExchangeResponseDto> delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
