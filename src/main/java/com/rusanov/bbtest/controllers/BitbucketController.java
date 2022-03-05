package com.rusanov.bbtest.controllers;

import com.rusanov.bbtest.services.RepositoryService;
import com.rusanov.bbtest.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitbucketController {
//TODO response answers
//     project and repoName parameters

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    TemplateService templateService;
    @PostMapping("/create")
    void createBitbucketRepository() {
        repositoryService.create();
    }

    @PostMapping("/initCommit")
    void initCommit() {
        templateService.createStandardTemplate();
    }

}
