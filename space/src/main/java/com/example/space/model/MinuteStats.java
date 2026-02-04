package com.example.space.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "minute_stats")
public class MinuteStats {

    @Id
    private Instant minuteStart;

    private int uniqueIdCount;

    protected MinuteStats() {}

    public MinuteStats(Instant minuteStart, int uniqueIdCount) {
        this.minuteStart = minuteStart;
        this.uniqueIdCount = uniqueIdCount;
    }
}
