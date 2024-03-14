package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.infrastructure.controller.githubdbdto.*;
import com.example.zadanie0202.github.infrastructure.controller.githubdto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.domain.model.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GithubMapper {

    public GetUsersRepositoriesResponseDto mapFromRepositoryListToGetUsersRepositoriesResponseDto(List<Repository> repositories) {
        return new GetUsersRepositoriesResponseDto(repositories);
    }

    public Repository mapFromPostRepositoryRequestDtoToRepository(PostRepositoryRequestDto dto) {
        return new Repository(dto.name(), dto.owner());
    }

    public PostRepositoryResponseDto mapFromRepositoryToPostRepositoryResponseDto (Repository repository) {
        return new PostRepositoryResponseDto(repository.getName(), repository.getOwnerLogin());
    }

    public Repository mapFromUpdateRepositoryRequestDtoToRepository(UpdateRepositoryRequestDto dto) {
        return new Repository(dto.name(), dto.owner());
    }

    public UpdateRepositoryResponseDto mapFromRepositoryToUpdateRepositoryResponseDto (Repository repository) {
        return new UpdateRepositoryResponseDto(repository.getName(), repository.getOwnerLogin());
    }

    public Repository mapFromPartiallyUpdateRepositoryRequestDtoToRepository(PartiallyUpdateRepositoryRequestDto requestDto) {
        return new Repository(requestDto.name(), requestDto.owner());
    }

    public PartiallyUpdateRepositoryResponseDto mapFromRepositorytoPartiallyUpdateRepositoryResponseDto(Repository savedRepository) {
        return new PartiallyUpdateRepositoryResponseDto(savedRepository.getName(), savedRepository.getOwnerLogin());
    }
}
