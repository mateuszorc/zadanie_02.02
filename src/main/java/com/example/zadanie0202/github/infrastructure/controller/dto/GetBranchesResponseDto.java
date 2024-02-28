package com.example.zadanie0202.github.infrastructure.controller.dto;

public record GetBranchesResponseDto(
        String name,
        CommitDto commit
) {
}
