package com.kimdev.trackarate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Comments")
public class Comment extends AbstractEntity {

    @Column(length = 120)
    private String title;

    @Column(nullable = false, length = 2000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "id_training_program")
    private TrainingProgram trainingProgram;

    @ManyToOne
    @JoinColumn(name = "id_training_session")
    private TrainingSession trainingSession;
}
