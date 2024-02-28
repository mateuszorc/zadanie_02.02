package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.infrastructure.controller.dto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.domain.model.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GithubMapper {

    public GetUsersRepositoriesResponseDto mapFromRepositoryListToGetUsersRepositoriesResponseDto(List<Repository> repositories) {
        return new GetUsersRepositoriesResponseDto(repositories);
    }
}
