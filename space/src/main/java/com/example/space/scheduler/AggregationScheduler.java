package com.example.space.scheduler;

import com.example.space.service.AggregationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AggregationScheduler {

    private final AggregationService aggregationService;

    public AggregationScheduler(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void aggregate() {
        aggregationService.aggregatePreviousMinute();
    }
}