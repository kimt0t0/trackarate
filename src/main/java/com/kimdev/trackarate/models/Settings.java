package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Settings {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private boolean isPrivate;

    @Column(nullable = true)
    private boolean evaluateTrainingsPerWeek = false;

    @Column(length = 2)
    private Integer trainingsPerWeek;

    @Column(nullable = true)
    private boolean evaluateTrainingsAverageDuration = false;

    @Column(length = 3)
    private Integer trainingsAverageDuration;

    @Column(length = 10)
    private String beltOrGrade;

    @Column
    private String goals;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    public Settings(boolean isPrivate, boolean evaluateTrainingsPerWeek, Integer trainingsPerWeek,
            boolean evaluateTrainingsAverageDuration, Integer trainingsAverageDuration, String beltOrGrade,
            String goals) {
        // this.isPrivate = isPrivate;
        // if (!isPrivate)
        // this.isPrivate = false;

        // this.evaluateTrainingsPerWeek = evaluateTrainingsPerWeek;
        // if (!evaluateTrainingsPerWeek)
        // this.evaluateTrainingsPerWeek = false;
        // this.trainingsPerWeek = trainingsPerWeek;

        // this.evaluateTrainingsAverageDuration = evaluateTrainingsAverageDuration;
        // if (!evaluateTrainingsAverageDuration)
        // this.evaluateTrainingsAverageDuration = false;

        // this.trainingsAverageDuration = trainingsAverageDuration;

        // this.beltOrGrade = beltOrGrade;

        // this.goals = goals;
    }
}
