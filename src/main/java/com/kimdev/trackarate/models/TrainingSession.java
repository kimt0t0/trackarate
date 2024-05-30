package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column
    private LocalDateTime datetime;

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
