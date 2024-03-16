package com.stocky.service;

import reactor.core.publisher.Mono;

public interface AlphaVantageService {

    Mono<String> getStockData(String ticker);
}
