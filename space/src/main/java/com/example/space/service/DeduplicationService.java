package com.example.space.service;



import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DeduplicationService {


    private final Map<Instant, Set<String>> minuteToIds = new ConcurrentHashMap<>();

    public void recordId(Instant minute, String id) {
        minuteToIds
                .computeIfAbsent(minute, k -> ConcurrentHashMap.newKeySet())
                .add(id);
    }

    public Set<String> removeMinute(Instant minute) {
        return minuteToIds.remove(minute);
    }
}