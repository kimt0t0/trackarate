package com.kimdev.trackarate.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.Settings;

public interface SettingsRepository extends JpaRepository<Settings, UUID> {

    Optional<Settings> findByUserId(UUID id);

    @Query(value = "select max(trainingsPerWeek) from settings", nativeQuery = true)
    Integer findHighestTrainingsPerWeek();

    @Query(value = "select max(trainingsAverageDuration) from settings", nativeQuery = true)
    Integer findHighestTrainingsAverageDuration();

    @Query(value = "select sum(trainingsPerWeek)/2 from settings", nativeQuery = true)
    Integer findAverageTrainingsPerWeek();

    @Query(value = "select sum(s.trainingsPerWeek)/2 from settings s inner join users u on u.id = s.user_id", nativeQuery = true)
    Integer findAverageTrainingsPerWeekByUserId(UUID id);

    @Query(value = "select sum(trainingsAverageDuration)/2 from settings", nativeQuery = true)
    Integer findAverageTrainingsDuration();

    @Query(value = "select sum(s.trainingsAverageDuration)/2 from settings s inner join users u on u.id = s.user_id", nativeQuery = true)
    Integer findAverageTrainingsDurationByUserId(UUID id);

}
