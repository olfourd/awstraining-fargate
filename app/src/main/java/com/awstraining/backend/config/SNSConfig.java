package com.awstraining.backend.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SNSConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.accessKey:#{null}}")
    private String snsAccessKey;

    @Value("${aws.secretKey:#{null}}")
    private String snsSecretKey;
    
    @Bean
    AmazonSNS configureSNSClient() {
        return AmazonSNSAsyncClientBuilder.standard()
            .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
            .withRegion(awsRegion)
            .build();
    }
}
