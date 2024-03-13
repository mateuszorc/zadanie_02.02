package com.example.zadanie0202.github.infrastructure.controller.githubdto;

import com.example.zadanie0202.github.domain.model.Repository;

import java.util.List;

public record GetUsersRepositoriesResponseDto(List<Repository> repositories) {
}
