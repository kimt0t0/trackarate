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
@Entity(name = "TrainingPrograms")
public class TrainingProgram {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique = true, nullable = false, updatable = false)
    private UUID id;

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

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;
}
