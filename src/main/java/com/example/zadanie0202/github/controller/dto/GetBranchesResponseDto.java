package com.example.zadanie0202.github.controller.dto;

import com.example.zadanie0202.github.controller.dto.CommitDto;

public record GetBranchesResponseDto(
        String name,
        CommitDto commit
) {
}
