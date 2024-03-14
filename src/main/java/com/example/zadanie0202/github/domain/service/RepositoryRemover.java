package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.repository.GithubRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RepositoryRemover {

    private final GithubRepository githubRepository;

    public RepositoryRemover(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public void deleteRepository(String name) {
        Long id = githubRepository.findByName(name).getId();
        log.info("deleting repository with id " + id);
        githubRepository.deleteById(id);
    }
}
