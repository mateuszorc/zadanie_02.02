package com.example.zadanie0202.github.domain.repository.dao;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "repo")
public class RepositoryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, name = "owner")
    String ownerLogin;

    public RepositoryDao() {
    }

    public RepositoryDao(String name, String ownerLogin) {
        this.name = name;
        this.ownerLogin = ownerLogin;
    }

    public RepositoryDao(Long id, String name, String ownerLogin) {
        this.id = id;
        this.name = name;
        this.ownerLogin = ownerLogin;
    }
}
