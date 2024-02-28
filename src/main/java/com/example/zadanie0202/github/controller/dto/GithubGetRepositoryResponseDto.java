package com.example.zadanie0202.github.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubGetRepositoryResponseDto(
        String name,
        RepositoryOwnerDto owner
) {
}
