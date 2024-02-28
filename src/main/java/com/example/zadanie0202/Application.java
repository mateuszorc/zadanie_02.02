package com.example.zadanie0202;

import com.example.zadanie0202.github.infrastructure.controller.GithubRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class Application {

    private final GithubRestController githubRestController;

    @Autowired
    public Application(GithubRestController githubRestController) {
        this.githubRestController = githubRestController;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
//        githubRestController.getUsersRespositories("sdasdasfaegw");
    }
}
