package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;
}
