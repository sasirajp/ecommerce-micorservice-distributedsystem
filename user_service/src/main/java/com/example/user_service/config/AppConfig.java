package com.example.user_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("eurekaRestTemplate")
    @LoadBalanced
    public RestTemplate lbRestTemplate() {
        return new RestTemplate(); // For Eureka services
    }

    @Bean
    public RestTemplate plainRestTemplate() {
        return new RestTemplate(); // For external DNS APIs
    }
}
