package com.kimdev.trackarate.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.models.Type;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TrainingSessionDto {
    private String name;

    private Integer duration;

    private LocalDateTime datetime;

    private UUID userId;

    private List<UUID> sessionTypesIds;

    private List<UUID> trainingProgramsIds;

    private List<UUID> exercisesIds;

    public static TrainingSessionDto fromEntity(TrainingSession session) {
        return TrainingSessionDto.builder()
                .name(session.getName())
                .duration(session.getDuration())
                .datetime(session.getDatetime())
                .userId(session.getUser().getId())
                .sessionTypesIds(
                        session.getSessionTypes()
                                .stream()
                                .map(Type::getId)
                                .collect(Collectors.toList()))
                .trainingProgramsIds(
                        session.getTrainingPrograms()
                                .stream()
                                .map(TrainingProgram::getId)
                                .collect(Collectors.toList()))
                .exercisesIds(
                        session.getExercises()
                                .stream()
                                .map(Exercise::getId)
                                .collect(Collectors.toList()))
                .build();
    }

    public static TrainingSession toEntity(TrainingSessionDto sessionDto) {
        TrainingSession trainingSession = TrainingSession.builder()
                .name(sessionDto.getName())
                .duration(sessionDto.getDuration())
                .datetime(sessionDto.getDatetime())
                .user(
                        User.builder()
                                .id(sessionDto.userId)
                                .build())
                .build();

        List<Type> sessionTypes = sessionDto.getSessionTypesIds()
                .stream()
                .map(id -> Type.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<TrainingProgram> trainingPrograms = sessionDto.getTrainingProgramsIds()
                .stream()
                .map(id -> TrainingProgram.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<Exercise> exercises = sessionDto.getExercisesIds()
                .stream()
                .map(id -> Exercise.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        trainingSession.setSessionTypes(sessionTypes);
        trainingSession.setTrainingPrograms(trainingPrograms);
        trainingSession.setExercises(exercises);

        return trainingSession;
    }
}
