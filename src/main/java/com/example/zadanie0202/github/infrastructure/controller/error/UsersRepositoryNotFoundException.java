package com.example.zadanie0202.github.infrastructure.controller.error;

public class UsersRepositoryNotFoundException extends RuntimeException {

    public UsersRepositoryNotFoundException(String message) {
        super(message);
    }
}
