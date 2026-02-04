package com.example.space.repository;

import com.example.space.model.MinuteStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface MinuteStatsRepository extends JpaRepository<MinuteStats, Instant> {
}
