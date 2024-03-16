package com.stocky.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(StockDataController.class)
class StockDataControllerTest {

    @Mock
    private StockDataController stockDataController;

    @Mock
    WebTestClient mockMvcWebTestClient;

    @Test
    void getStockData() {
        //test case for StockDataController
        mockMvcWebTestClient.get().uri("/api/v1/stock-data/get-data/IBM")
                .exchange()
                .expectStatus().isOk();
    }
}