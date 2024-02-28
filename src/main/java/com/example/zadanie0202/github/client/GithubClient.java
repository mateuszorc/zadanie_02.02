package com.example.zadanie0202.github.client;

import com.example.zadanie0202.github.controller.dto.GithubGetRepositoryResponseDto;
import com.example.zadanie0202.github.controller.dto.GetBranchesResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("github-client")
public interface GithubClient {

    @GetMapping("/users/{username}/repos")
    List<GithubGetRepositoryResponseDto> getUserRepositories(
            @PathVariable String username
    );

    @GetMapping("/repos/{username}/{repositoryName}/branches")
    List<GetBranchesResponseDto> getBranchesByRepoName(
        @PathVariable String username,
        @PathVariable String repositoryName
    );
}
