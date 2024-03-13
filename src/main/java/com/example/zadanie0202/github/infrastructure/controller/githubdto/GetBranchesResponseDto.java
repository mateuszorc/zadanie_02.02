package com.example.zadanie0202.github.infrastructure.controller.githubdto;

public record GetBranchesResponseDto(
        String name,
        CommitDto commit
) {
}
