package com.example.zadanie0202.github.domain.model;

import java.util.List;

public record Repository(
        String name,
        String ownerLogin,
        List<Branch> branches
) {
}
