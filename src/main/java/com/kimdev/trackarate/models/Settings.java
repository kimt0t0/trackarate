package com.kimdev.trackarate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
public class Settings extends AbstractEntity {

    @Column(nullable = false)
    private boolean isPrivate;

    @Column(nullable = true)
    private boolean isEvaluateTrainingsPerWeek;

    @Column(length = 2)
    private Integer trainingsPerWeek;

    @Column(nullable = true)
    private boolean isEvaluateTrainingsAverageDuration;

    @Column(length = 3)
    private Integer trainingsAverageDuration;

    @Column(length = 10)
    private String beltOrGrade;

    @Column
    private String goals;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
