package com.stocky.service.impl;

import com.stocky.service.InidactorCalculator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class IndicatorCalculatorServiceImpl implements InidactorCalculator {

    private static final double MULTIPLIER = 2.0;

    @Override
    public Flux<Double> calculateEMA(Flux<Double> priceFlux, int period) {
        // Use buffer to create a rolling window of prices with a size equal to the period
        return priceFlux.buffer(period, 1)
                .filter(list -> list.size() == period) // Ensure each list has the exact period size
                .flatMap(list -> calculateEmaValues(list, period));
    }

    protected Flux<Double> calculateEmaValues(List<Double> prices, int period) {
        double sma = calculateSMA(prices, period);
        return Flux.fromIterable(prices)
                .skip(period)
                .scan(sma, (ema, price) -> (price - ema) * MULTIPLIER + ema);
    }

    protected double calculateSMA(List<Double> prices, int period) {
        return prices.stream()
                .limit(period)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }
}
