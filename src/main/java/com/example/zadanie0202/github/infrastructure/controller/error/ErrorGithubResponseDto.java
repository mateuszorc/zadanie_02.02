package com.example.zadanie0202.github.infrastructure.controller.error;

import org.springframework.http.HttpStatus;

public record ErrorGithubResponseDto(
        HttpStatus httpStatus,
        String message
) {
}
