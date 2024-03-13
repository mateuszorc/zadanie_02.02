package com.example.zadanie0202.github.infrastructure.controller;

import com.example.zadanie0202.github.domain.service.GithubMapper;
import com.example.zadanie0202.github.infrastructure.controller.dto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.domain.service.RepositoryRetriever;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/db")
@Log4j2
public class GithubDbRestController {
    
    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<GetUsersRepositoriesResponseDto> getUsersRespositories(@PathVariable String username) {
        List<Repository> usersRepositoriesWithBranches = repositoryRetriever.getUsersRepositoriesWithBranches(username);
        GetUsersRepositoriesResponseDto responseDto = githubMapper.mapFromRepositoryListToGetUsersRepositoriesResponseDto(usersRepositoriesWithBranches);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}