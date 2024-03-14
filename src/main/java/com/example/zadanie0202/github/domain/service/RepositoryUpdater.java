package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.repository.GithubRepository;
import lombok.Builder;
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

    public void updateById(String name, Repository repository) {
        Long id = githubRepository.findByName(name).getId();
        log.info("updating repository with id " + id + " - new name: " + repository.getName() + ", new owner: " + repository.getOwnerLogin());
        githubRepository.updateById(id, repository);
    }

    public Repository partiallyUpdateRepository(String name, Repository repository) {
        Repository dbRepository = githubRepository.findByName(name);
        Repository.RepositoryBuilder builder = Repository.builder();
        if (repository.getName() != null) {
            builder.name(repository.getName());
        } else {
            builder.name(dbRepository.getName());
        }
        if (repository.getOwnerLogin() != null) {
            builder.ownerLogin(repository.getOwnerLogin());
        } else {
            builder.ownerLogin(dbRepository.getOwnerLogin());
        }
        Repository toSave = builder.build();
        githubRepository.updateById(dbRepository.getId(), toSave);
        return toSave;
    }
}
