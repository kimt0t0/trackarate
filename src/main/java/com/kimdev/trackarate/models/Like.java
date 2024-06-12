package com.kimdev.trackarate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Likes")
public class Like extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
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
