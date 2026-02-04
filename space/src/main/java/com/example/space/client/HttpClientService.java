package com.example.space.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpClientService {

    private static final Logger log = LoggerFactory.getLogger(HttpClientService.class);

    private final WebClient webClient;

    public HttpClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void callEndpoint(String endpoint) {
        webClient.get()
                .uri(endpoint)
                .exchangeToMono(response -> {
                    HttpStatusCode status = response.statusCode();
                    log.info("Called endpoint={}, status={}", endpoint, status.value());
                    return Mono.empty();
                })
                .doOnError(e ->
                        log.error("Failed to call endpoint={}", endpoint, e))
                .subscribe();
    }
}