package com.example.zadanie0202.github.controller.dto;

import com.example.zadanie0202.github.controller.model.Repository;

import java.util.List;

public record GetUsersRepositoriesResponseDto(List<Repository> repositories) {
}
