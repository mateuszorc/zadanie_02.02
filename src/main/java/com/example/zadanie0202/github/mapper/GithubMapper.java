package com.example.zadanie0202.github.mapper;

import com.example.zadanie0202.github.controller.dto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.controller.model.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GithubMapper {

    public GetUsersRepositoriesResponseDto mapFromRepositoryListToGetUsersRepositoriesResponseDto(List<Repository> repositories) {
        return new GetUsersRepositoriesResponseDto(repositories);
    }
}
