package com.example.space.service;

import com.example.space.model.MinuteStats;
import com.example.space.repository.MinuteStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Service
public class AggregationService {

    private static final Logger log = LoggerFactory.getLogger(AggregationService.class);

    private final DeduplicationService deduplicationService;
    private final MinuteStatsRepository repository;

    public AggregationService(DeduplicationService deduplicationService,
                              MinuteStatsRepository repository) {
        this.deduplicationService = deduplicationService;
        this.repository = repository;
    }

    public void aggregatePreviousMinute() {
        Instant minute = Instant.now()
                .minus(1, ChronoUnit.MINUTES)
                .truncatedTo(ChronoUnit.MINUTES);

        Set<String> ids = deduplicationService.removeMinute(minute);
        int count = ids == null ? 0 : ids.size();

        log.info("{} -> {} unique ids", minute, count);

        repository.save(new MinuteStats(minute, count));
    }
}
