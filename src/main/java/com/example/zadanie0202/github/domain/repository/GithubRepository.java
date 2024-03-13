package com.example.zadanie0202.github.domain.repository;

import com.example.zadanie0202.github.domain.repository.dao.RepositoryDao;
import org.springframework.data.repository.Repository;


public interface GithubRepository extends Repository<RepositoryDao, Long> {


    void save(RepositoryDao repo);
}
