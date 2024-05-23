package com.kimdev.trackarate.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    private User(String username, String email, String phone) {
        // this.username = username;
        // this.email = email;
        // this.phone = phone;
    }

}
