package com.example.zadanie0202.github.error;

import org.springframework.http.HttpStatus;

public record ErrorGithubResponseDto(
        HttpStatus httpStatus,
        String message
) {
}
