package com.example.zadanie0202.github.domain.repository;


import com.example.zadanie0202.github.domain.model.Repository;

public interface GithubRepository extends org.springframework.data.repository.Repository<Repository, Long> {


    void save(Repository repo);
}
