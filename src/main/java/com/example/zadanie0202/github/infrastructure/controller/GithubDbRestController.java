package com.example.zadanie0202.github.infrastructure.controller;

import com.example.zadanie0202.github.domain.service.FromDbRepositoryRetriever;
import com.example.zadanie0202.github.domain.service.GithubMapper;
import com.example.zadanie0202.github.infrastructure.controller.dto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.domain.model.Repository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/db")
@Log4j2
public class GithubDbRestController {

    private final FromDbRepositoryRetriever fromDbRepositoryRetriever;
    private final GithubMapper githubMapper;

    public GithubDbRestController(FromDbRepositoryRetriever fromDbRepositoryRetriever, GithubMapper githubMapper) {
        this.fromDbRepositoryRetriever = fromDbRepositoryRetriever;
        this.githubMapper = githubMapper;
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<GetUsersRepositoriesResponseDto> getUsersRespositories(@PathVariable String username, Pageable pageable) {
        List<Repository> usersRepositoriesWithBranches = fromDbRepositoryRetriever.getUsersRepositories(username, pageable);
        GetUsersRepositoriesResponseDto responseDto = githubMapper.mapFromRepositoryListToGetUsersRepositoriesResponseDto(usersRepositoriesWithBranches);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}