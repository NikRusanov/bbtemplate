package com.rusanov.bbtest.configuration;

import com.cdancy.bitbucket.rest.BitbucketAuthentication;
import com.cdancy.bitbucket.rest.BitbucketClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Base64;

@Configuration
@PropertySource("classpath:credentials.properties")
public class BitbucketClientConfiguration {
    @Bean
    public BitbucketClient getClient(@Value("${credentials}") String credentials, @Value("${endpoint}") String endpoint) {
        return BitbucketClient.builder().endPoint(endpoint).credentials(credentials).build();
    }

}
