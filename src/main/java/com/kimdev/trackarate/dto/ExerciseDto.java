package com.kimdev.trackarate.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.models.Type;
import com.kimdev.trackarate.models.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExerciseDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 120)
    private String title;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 5000)
    private String description;

    @Size(min = 1, max = 15)
    private TrainingState state;

    @Size(min = 1, max = 15)
    private TrainingFeeling feeling;

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    private List<UUID> exerciseTypesIds;

    private List<UUID> trainingSessionsIds;

    public static ExerciseDto fromEntity(Exercise exercise) {
        return ExerciseDto.builder()
                .title(exercise.getTitle())
                .description(exercise.getDescription())
                .state(exercise.getState())
                .feeling(exercise.getFeeling())
                .userId(exercise.getUser().getId())
                .exerciseTypesIds(
                        exercise.getExerciseTypes()
                                .stream()
                                .map(Type::getId)
                                .collect(Collectors.toList()))
                .trainingSessionsIds(
                        exercise.getTrainingSessions()
                                .stream()
                                .map(TrainingSession::getId)
                                .collect(Collectors.toList()))
                .build();
    }

    public static Exercise toEntity(ExerciseDto exerciseDto) {
        Exercise exercise = Exercise.builder()
                .title(exerciseDto.getTitle())
                .description(exerciseDto.getDescription())
                .state(exerciseDto.getState())
                .feeling(exerciseDto.getFeeling())
                .user(
                        User.builder()
                                .id(exerciseDto.userId)
                                .build())
                .build();

        List<Type> exerciseTypes = exerciseDto.getExerciseTypesIds()
                .stream()
                .map(id -> Type.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<TrainingSession> trainingSessions = exerciseDto.getTrainingSessionsIds()
                .stream()
                .map(id -> TrainingSession.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        exercise.setExerciseTypes(exerciseTypes);
        exercise.setTrainingSessions(trainingSessions);

        return exercise;
    }

}
