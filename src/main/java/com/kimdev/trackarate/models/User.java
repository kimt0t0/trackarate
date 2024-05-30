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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    @OneToOne(mappedBy = "user")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany
    @JoinTable(name = "users_senseis", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "sensei_id"))
    private List<User> senseiList;

    @ManyToMany
    @JoinTable(name = "users_students", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<User> studentsList;

    @ManyToMany
    @JoinTable(name = "users_contacts", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<User> contactsList;

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

}
