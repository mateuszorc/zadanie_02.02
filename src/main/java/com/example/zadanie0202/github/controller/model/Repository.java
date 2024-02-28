package com.example.zadanie0202.github.controller.model;

import com.example.zadanie0202.github.controller.dto.GetBranchesResponseDto;

import java.util.List;

public record Repository(
        String name,
        String ownerLogin,
        List<Branch> branches
) {
}
