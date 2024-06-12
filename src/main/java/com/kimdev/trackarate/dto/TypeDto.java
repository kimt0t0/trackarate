package com.kimdev.trackarate.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.models.Type;

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
public class TypeDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    private List<UUID> exercisesIds;

    private List<UUID> sessionsIds;

    private List<UUID> programsIds;

    public static TypeDto fromEntity(Type type) {
        return TypeDto.builder()
                .name(type.getName())
                .exercisesIds(
                        type.getExercises()
                                .stream()
                                .map(Exercise::getId)
                                .collect(Collectors.toList()))
                .sessionsIds(
                        type.getSessions()
                                .stream()
                                .map(TrainingSession::getId)
                                .collect(Collectors.toList()))
                .programsIds(
                        type.getPrograms()
                                .stream()
                                .map(TrainingProgram::getId)
                                .collect(Collectors.toList()))
                .build();
    }

    public static Type toEntity(TypeDto typeDto) {
        Type type = Type.builder()
                .name(typeDto.getName())
                .build();

        List<Exercise> exercises = typeDto.getExercisesIds()
                .stream()
                .map(id -> Exercise.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<TrainingSession> sessions = typeDto.getSessionsIds()
                .stream()
                .map(id -> TrainingSession.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<TrainingProgram> programs = typeDto.getProgramsIds()
                .stream()
                .map(id -> TrainingProgram.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        type.setExercises(exercises);
        type.setSessions(sessions);
        type.setPrograms(programs);

        return type;
    }
}
