package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.repository.GithubRepository;
import com.example.zadanie0202.github.domain.repository.dao.RepositoryDao;
import com.example.zadanie0202.github.infrastructure.controller.dto.GithubGetRepositoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FromGithubRepositoryToDbSaver {

    private final GithubRepository githubRepository;


    public FromGithubRepositoryToDbSaver(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public void saveAll(List<GithubGetRepositoryResponseDto> repos) {
        List<RepositoryDao> repositoriesToSave = mapFromGithubGetRepositoryResponseDtoToReposiotryDao(repos);
        repositoriesToSave.forEach(githubRepository::save);
    }

    private static List<RepositoryDao> mapFromGithubGetRepositoryResponseDtoToReposiotryDao(List<GithubGetRepositoryResponseDto> repos) {
        return repos.stream()
                .map(repo -> new RepositoryDao(repo.name(), repo.owner().login()))
                .toList();
    }
}
