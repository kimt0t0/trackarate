package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, unique = true, length = 26)
    private String username;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = true, unique = true, length = 14)
    private String phone;

    @OneToOne(mappedBy = "user")
    private Settings settings;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    // @ManyToMany
    // @JsonBackReference
    // private User sensei;

    // @ManyToMany
    // @JsonBackReference
    // private List<User> students;

    // @ManyToMany
    // @JsonBackReference
    // private List<User> contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TrainingProgram> trainingPrograms;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TrainingSession> trainingSessions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Exercise> exercises;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
    private List<Answer> answers;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
    private List<Like> likes;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
    private List<Comment> comments;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    public User(String username, String email, String phone) {
        // this.username = username;
        // this.email = email;
        // this.phone = phone;
    }

}
