package com.example.zadanie0202.github.error;

import com.example.zadanie0202.github.controller.GithubRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = GithubRestController.class)
@Log4j2
public class GithubErrorHandler extends Throwable {

    @ExceptionHandler(UsersRepositoryNotFoundException.class)
    public ResponseEntity<ErrorGithubResponseDto> handleNotFoundException(UsersRepositoryNotFoundException exception) {
        log.warn("UsersRepositoryNotFoundException while getting repositories");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorGithubResponseDto(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorGithubResponseDto> handleHttpMediaTypeNotAcceptableException() {
        log.warn("NotAcceptableFormat while getting repositories");
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ErrorGithubResponseDto(HttpStatus.NOT_ACCEPTABLE, "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE));
    }

}
