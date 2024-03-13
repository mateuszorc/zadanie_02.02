package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.repository.GithubRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FromDbRepositoryRetriever {

    private final GithubRepository githubRepository;

    public FromDbRepositoryRetriever(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public List<Repository> getUsersRepositories(String username, Pageable pageable) {
        return githubRepository.findAllByOwner(username, pageable);
    }
}
