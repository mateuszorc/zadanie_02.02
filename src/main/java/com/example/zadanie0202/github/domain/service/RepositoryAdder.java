package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.repository.GithubRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RepositoryAdder {

    private final GithubRepository githubRepository;

    public RepositoryAdder(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public Repository add(Repository repositoryToSave) {
        githubRepository.save(repositoryToSave);
        log.info("adding repository - name: " + repositoryToSave.getName() + ", owner: " + repositoryToSave.getOwnerLogin());
        return repositoryToSave;
    }
}
