package com.sparta.currency_user.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
    private final String code;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<validationError> errors;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class validationError {
        private final String field;
        private final String message;

        public static validationError of(final FieldError fieldError) {
            return validationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
    }
}
