package com.example.zadanie0202.github.infrastructure.controller.githubdbdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PostRepositoryRequestDto(
        @NotNull
        @NotEmpty
        String name,

        @NotNull
        @NotEmpty
        String owner
) {
}
