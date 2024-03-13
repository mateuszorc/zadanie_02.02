package com.example.zadanie0202.github.domain.repository;


import com.example.zadanie0202.github.domain.model.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GithubRepository extends org.springframework.data.repository.Repository<Repository, Long> {


    @Query("SELECT r FROM Repository r WHERE r.name=:username")
    List<Repository> findAllByName(String username, Pageable pageable);

    void save(Repository repo);
}
