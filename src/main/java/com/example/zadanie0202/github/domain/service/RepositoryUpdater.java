package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.repository.GithubRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
public class RepositoryUpdater {

    private final GithubRepository githubRepository;

    public RepositoryUpdater(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public void updateById(Long id, Repository repository) {
        githubRepository.findById(id);
        log.info("updating repository with id " + id + " - new name: " + repository.getName() + ", new owner: " + repository.getOwnerLogin());
        githubRepository.updateById(id, repository);
    }
}
