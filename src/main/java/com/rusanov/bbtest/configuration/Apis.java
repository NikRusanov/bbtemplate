package com.rusanov.bbtest.configuration;

import com.cdancy.bitbucket.rest.BitbucketClient;
import com.cdancy.bitbucket.rest.domain.commit.Commit;
import com.cdancy.bitbucket.rest.domain.repository.Repository;
import com.cdancy.bitbucket.rest.features.*;
import com.cdancy.bitbucket.rest.options.CreateRepository;
import com.fasterxml.jackson.databind.type.MapLikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Apis {
    @Autowired
    private BitbucketClient bitbucketClient;

    @Bean
    public RepositoryApi getRepositoryApi() {
        return bitbucketClient.api().repositoryApi();
    }

    @Bean
    public CommitsApi getCommit() {
        return bitbucketClient.api().commitsApi();
    }

    @Bean
    public FileApi getFileApi() {
        return bitbucketClient.api().fileApi();
    }

    @Bean
    public AdminApi getAdminApi() {
        return bitbucketClient.api().adminApi();
    }


    @Bean
    public BranchApi getBranchApi() {
        return bitbucketClient.api().branchApi();
    }
}
