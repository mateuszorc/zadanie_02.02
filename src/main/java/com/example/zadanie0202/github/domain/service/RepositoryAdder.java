package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.repository.GithubRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryAdder {

    private final GithubRepository githubRepository;

    public RepositoryAdder(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public Repository add(Repository repositoryToSave) {
        githubRepository.save(repositoryToSave);
        return repositoryToSave;
    }
}
