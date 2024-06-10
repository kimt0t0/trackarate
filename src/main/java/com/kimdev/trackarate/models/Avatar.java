package com.kimdev.trackarate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity(name = "Avatars")
public class Avatar extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 255)
    private String path;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
