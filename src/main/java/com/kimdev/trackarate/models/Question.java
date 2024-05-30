package com.kimdev.trackarate.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Questions")
public class Question extends AbstractEntity {

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 2000)
    private String details;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
