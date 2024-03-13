package com.example.zadanie0202.github.domain.repository;


import com.example.zadanie0202.github.domain.model.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GithubRepository extends org.springframework.data.repository.Repository<Repository, Long> {


    @Query("SELECT r FROM Repository r WHERE r.ownerLogin=:username")
    List<Repository> findAllByOwner(String username, Pageable pageable);

    @Query("SELECT r FROM Repository r WHERE r.id=:id")
    Repository findById(Long id);

    void save(Repository repo);

    @Modifying
    @Query("UPDATE Repository r SET r.name=:#{#repository.name}, r.ownerLogin=:#{#repository.ownerLogin} WHERE r.id=:id")
    void updateById(Long id, Repository repository);
}
