package com.kimdev.trackarate.models;

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
@Entity(name = "TrainingPrograms")
public class TrainingProgram extends AbstractEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 3)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "programs_types", joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> programTypes;

    @ManyToMany
    @JoinTable(name = "programs_sessions", joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "session_id"))
    private List<TrainingSession> trainingSessions;

    @OneToMany(mappedBy = "trainingProgram")
    private List<Comment> comments;

    @OneToMany(mappedBy = "trainingProgram")
    private List<Like> likes;
}
