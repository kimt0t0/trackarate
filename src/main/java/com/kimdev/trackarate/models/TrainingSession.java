package com.kimdev.trackarate.models;

import java.time.ZonedDateTime;
import java.util.List;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "TrainingSessions")
public class TrainingSession extends AbstractEntity {

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 3)
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TrainingState state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TrainingFeeling feeling;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "sessions_types", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> sessionTypes;

    @ManyToMany(mappedBy = "trainingSessions")
    private List<TrainingProgram> trainingPrograms;

    @ManyToMany
    @JoinTable(name = "sessions_exercises", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    @OneToMany(mappedBy = "trainingSession")
    private List<Comment> comments;

    @OneToMany(mappedBy = "trainingSession")
    private List<Like> likes;
}
