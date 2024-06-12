package com.kimdev.trackarate.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "Types")
public class Type {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "exerciseTypes")
    private List<Exercise> exercises;

    @ManyToMany(mappedBy = "sessionTypes")
    private List<TrainingSession> sessions;

    @ManyToMany(mappedBy = "programTypes")
    private List<TrainingProgram> programs;
}
