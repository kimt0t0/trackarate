package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "TrainingSessions")
public class TrainingSession {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique = true, nullable = false, updatable = false)
    private UUID id;

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

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

}
