package com.kimdev.trackarate.models;

import com.kimdev.trackarate.enums.MediaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Media")
public class Media extends AbstractEntity {

    @Column(unique = true, nullable = false, length = 255)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private MediaType type;

    @Column(nullable = false, length = 255)
    private String path;

    @ManyToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;
}
