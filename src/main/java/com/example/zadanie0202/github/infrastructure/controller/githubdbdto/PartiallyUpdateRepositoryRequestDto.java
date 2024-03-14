package com.example.zadanie0202.github.infrastructure.controller.githubdbdto;

public record PartiallyUpdateRepositoryRequestDto(
        String name,
        String owner
) {
}
