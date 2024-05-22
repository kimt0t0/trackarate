package com.kimdev.trackarate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private User(String username) {
    }

}
