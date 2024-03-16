package com.stocky.service;

import reactor.core.publisher.Flux;

public interface InidactorCalculator {

    Flux<Double> calculateEMA(Flux<Double> stockData, int period);
}
