package com.rusanov.bbtest.services;


import com.cdancy.bitbucket.rest.domain.repository.Repository;
import com.cdancy.bitbucket.rest.features.RepositoryApi;
import com.cdancy.bitbucket.rest.options.CreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements RepositoryService{
    @Autowired
    RepositoryApi repositoryApi;
    @Override
    public void create() {
        //TODO parameters from controller
        String projectKey = "TEST";
        final CreateRepository createRepository = CreateRepository.create("test", "test from api", true);
        //TODO error handlers
        Repository repository = repositoryApi.create(projectKey, createRepository);

    }
}
