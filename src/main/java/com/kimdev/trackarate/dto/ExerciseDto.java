package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExerciseDto {

    private String title;

    private String description;

    private UUID userId;

    public static ExerciseDto fromEntity(Exercise exercise) {
        return ExerciseDto.builder()
                .title(exercise.getTitle())
                .description(exercise.getDescription())
                .userId(exercise.getUser().getId())
                .build();
    }

    public static Exercise toEntity(ExerciseDto exerciseDto) {
        return Exercise.builder()
                .title(exerciseDto.getTitle())
                .description(exerciseDto.getDescription())
                .user(
                        User.builder()
                                .id(exerciseDto.userId)
                                .build())
                .build();
    }

}
