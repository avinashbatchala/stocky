package com.stocky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StockyWebClient {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://www.alphavantage.co")
                .build();
    }
}
