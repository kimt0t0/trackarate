package com.kimdev.trackarate.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
public class TrainingProgramDto {

    private String name;

    private Integer duration;

    private UUID userId;

    private List<UUID> programTypesIds;

    private List<UUID> trainingSessionsIds;

    public static TrainingProgramDto fromEntity(TrainingProgram program) {
        return TrainingProgramDto.builder()
                .name(program.getName())
                .duration(program.getDuration())
                .userId(program.getUser().getId())
                .programTypesIds(
                        program.getProgramTypes()
                                .stream()
                                .map(Type::getId)
                                .collect(Collectors.toList()))
                .trainingSessionsIds(
                        program.getTrainingSessions()
                                .stream()
                                .map(TrainingSession::getId)
                                .collect(Collectors.toList()))
                .build();
    }

    public static TrainingProgram toEntity(TrainingProgramDto programDto) {
        TrainingProgram trainingProgram = TrainingProgram.builder()
                .name(programDto.getName())
                .duration(programDto.getDuration())
                .user(
                        User.builder()
                                .id(programDto.userId)
                                .build())
                .build();

        List<Type> programTypes = programDto.getProgramTypesIds()
                .stream()
                .map(id -> Type.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<TrainingSession> trainingSessions = programDto.getTrainingSessionsIds()
                .stream()
                .map(id -> TrainingSession.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        trainingProgram.setProgramTypes(programTypes);
        trainingProgram.setTrainingSessions(trainingSessions);

        return trainingProgram;
    }
}
