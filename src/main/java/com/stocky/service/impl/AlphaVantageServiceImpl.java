package com.stocky.service.impl;

import com.stocky.service.AlphaVantageService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AlphaVantageServiceImpl implements AlphaVantageService {

    private final WebClient webClient;

    public AlphaVantageServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<String> getStockData(String ticker) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "TIME_SERIES_INTRADAY")
                        .queryParam("symbol", ticker)
                        .queryParam("interval", "5min")
                     //   .queryParam("outputsize", "full")
                        .queryParam("apikey", "9VSYFQFJGH1BS0U9")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
