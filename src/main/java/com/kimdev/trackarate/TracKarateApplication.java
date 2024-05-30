package com.kimdev.trackarate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TracKarateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracKarateApplication.class, args);
    }
}