package com.example.space.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.space.client.HttpClientService;

@Service
public class IngestionService {

    private final DeduplicationService deduplicationService;
    private final HttpClientService httpClientService;

    public IngestionService(DeduplicationService deduplicationService,
                            HttpClientService httpClientService) {
        this.deduplicationService = deduplicationService;
        this.httpClientService = httpClientService;
    }

    public void process(String id, String endpoint) {
        Instant minuteBucket = Instant.now().truncatedTo(ChronoUnit.MINUTES);

        deduplicationService.recordId(minuteBucket, id);

        if (endpoint != null && !endpoint.isEmpty()) {
            httpClientService.callEndpoint(endpoint);
        }
    }
}