package com.example.zadanie0202.github.infrastructure.controller;

import com.example.zadanie0202.github.domain.service.*;
import com.example.zadanie0202.github.infrastructure.controller.githubdbdto.*;
import com.example.zadanie0202.github.infrastructure.controller.githubdto.GetUsersRepositoriesResponseDto;
import com.example.zadanie0202.github.domain.model.Repository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/repositories")
@Log4j2
public class GithubDbRestController {

    private final FromDbRepositoryRetriever fromDbRepositoryRetriever;
    private final RepositoryAdder repositoryAdder;
    private final RepositoryUpdater repositoryUpdater;
    private final RepositoryRemover repositoryRemover;
    private final GithubMapper githubMapper;

    public GithubDbRestController(FromDbRepositoryRetriever fromDbRepositoryRetriever, RepositoryAdder repositoryAdder,
                                  RepositoryUpdater repositoryUpdater, RepositoryRemover repositoryRemover, GithubMapper githubMapper) {
        this.fromDbRepositoryRetriever = fromDbRepositoryRetriever;
        this.repositoryAdder = repositoryAdder;
        this.repositoryUpdater = repositoryUpdater;
        this.repositoryRemover = repositoryRemover;
        this.githubMapper = githubMapper;
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<GetUsersRepositoriesResponseDto> getUsersRespositories(@PathVariable String username, Pageable pageable) {
        List<Repository> usersRepositoriesWithBranches = fromDbRepositoryRetriever.getUsersRepositories(username, pageable);
        GetUsersRepositoriesResponseDto responseDto = githubMapper.mapFromRepositoryListToGetUsersRepositoriesResponseDto(usersRepositoriesWithBranches);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PostMapping()
    public ResponseEntity<PostRepositoryResponseDto> postRepository(@RequestBody PostRepositoryRequestDto requestDto) {
        Repository repositoryToSave = githubMapper.mapFromPostRepositoryRequestDtoToRepository(requestDto);
        Repository added = repositoryAdder.add(repositoryToSave);
        PostRepositoryResponseDto postRepositoryResponseDto = githubMapper.mapFromRepositoryToPostRepositoryResponseDto(added);
        return ResponseEntity.status(HttpStatus.OK).body(postRepositoryResponseDto);
    }

    @PutMapping(value = "/{name}")
    public ResponseEntity<UpdateRepositoryResponseDto> updateRepositoryByName(@PathVariable String name,
                                                                              @RequestBody @Valid UpdateRepositoryRequestDto requestDto) {
        Repository repository = githubMapper.mapFromUpdateRepositoryRequestDtoToRepository(requestDto);
        repositoryUpdater.updateById(name, repository);
        UpdateRepositoryResponseDto updateRepositoryResponseDto = githubMapper.mapFromRepositoryToUpdateRepositoryResponseDto(repository);
        return ResponseEntity.status(HttpStatus.OK).body(updateRepositoryResponseDto);
    }

    @PatchMapping(value = "/{name}")
    public ResponseEntity<PartiallyUpdateRepositoryResponseDto> partiallyUpdateRepository(@PathVariable String name,
                                                                                          @RequestBody PartiallyUpdateRepositoryRequestDto requestDto) {
        Repository repository = githubMapper.mapFromPartiallyUpdateRepositoryRequestDtoToRepository(requestDto);
        Repository savedRepository = repositoryUpdater.partiallyUpdateRepository(name, repository);
        PartiallyUpdateRepositoryResponseDto partiallyUpdateRepositoryResponseDto = githubMapper.mapFromRepositorytoPartiallyUpdateRepositoryResponseDto(savedRepository);
        return ResponseEntity.ok().body(partiallyUpdateRepositoryResponseDto);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<DeleteRepositoryResponseDto> deleteRepositoryByName(@PathVariable String name) {
        repositoryRemover.deleteRepository(name);
        return ResponseEntity.ok().body(new DeleteRepositoryResponseDto("Deleted repository with name " + name, HttpStatus.OK));
    }
}