package com.kimdev.trackarate.models;

import java.util.List;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Exercises")
public class Exercise extends AbstractEntity {

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TrainingState state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TrainingFeeling feeling;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<Media> mediaList;

    @ManyToMany
    @JoinTable(name = "exercises_types", joinColumns = @JoinColumn(name = "exercise_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> exerciseTypes;

    @ManyToMany(mappedBy = "exercises")
    private List<TrainingSession> trainingSessions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<Like> likes;
}
