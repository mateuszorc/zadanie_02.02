package com.example.zadanie0202.github.infrastructure.controller.githubdbdto;

import org.springframework.http.HttpStatus;

public record DeleteRepositoryResponseDto(
        String message,
        HttpStatus status
) {
}
