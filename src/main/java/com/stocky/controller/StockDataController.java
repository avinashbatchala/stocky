package com.stocky.controller;

import com.stocky.service.AlphaVantageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/stock-data")
public class StockDataController {

    private final AlphaVantageService alphaVantageService;

    public StockDataController(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @GetMapping("/get-data/{ticker}")
    public Mono<String> getStockData(@PathVariable String ticker) {
        return alphaVantageService.getStockData(ticker);
    }
}
