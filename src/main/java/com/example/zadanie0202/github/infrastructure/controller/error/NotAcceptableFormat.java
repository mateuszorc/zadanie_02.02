package com.example.zadanie0202.github.infrastructure.controller.error;

public class NotAcceptableFormat extends RuntimeException{

    public NotAcceptableFormat (String message) {
        super(message);
    }
}
