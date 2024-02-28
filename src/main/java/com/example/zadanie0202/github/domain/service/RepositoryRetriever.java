package com.example.zadanie0202.github.domain.service;

import com.example.zadanie0202.github.infrastructure.client.GithubClient;
import com.example.zadanie0202.github.infrastructure.controller.dto.GithubGetRepositoryResponseDto;
import com.example.zadanie0202.github.infrastructure.controller.dto.GetBranchesResponseDto;
import com.example.zadanie0202.github.domain.model.Branch;
import com.example.zadanie0202.github.domain.model.Repository;
import com.example.zadanie0202.github.infrastructure.controller.error.UsersRepositoryNotFoundException;
import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RepositoryRetriever {

    private final GithubClient githubClient;

    @Autowired
    public RepositoryRetriever(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public List<Repository> getUsersRepositoriesWithBranches(String username) {
        try {
            List<GithubGetRepositoryResponseDto> userRepositories = getUsersRepositories(username);
            List<Repository> repositories = userRepositories.stream()
                    .map(repo -> new Repository(repo.name(), repo.owner().login(), getBranchesByUserAndRepoName(repo.owner().login(), repo.name())))
                    .toList();
            log.info(repositories);
            return repositories;
        } catch (FeignException.FeignClientException e) {
            throw new UsersRepositoryNotFoundException("There are no repositories for username: " + username);
        }
    }

    private List<GithubGetRepositoryResponseDto> getUsersRepositories(String username) {
        return githubClient.getUserRepositories(username);
    }

    private List<Branch> getBranchesByUserAndRepoName(String username, String repoName) {
        List<GetBranchesResponseDto> branchesByRepoName = githubClient.getBranchesByRepoName(username, repoName);

        return branchesByRepoName.stream()
                .map(response -> new Branch(response.name(), response.commit().sha()))
                .collect(Collectors.toList());
    }
}
