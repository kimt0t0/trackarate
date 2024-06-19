package com.kimdev.trackarate.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.annotation.CreatedDate;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.models.Type;
import com.kimdev.trackarate.models.User;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TrainingProgramDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @Positive
    @Min(5)
    @Max(300)
    private Integer duration;

    @Size(min = 1, max = 15)
    private TrainingState state;

    @Size(min = 1, max = 15)
    private TrainingFeeling feeling;

    @CreatedDate
    private Date startDate;

    @CreatedDate
    private Date endDate;

    @NotNull
    @NotEmpty
    @NotBlank
    private UUID userId;

    private List<UUID> programTypesIds;

    private List<UUID> trainingSessionsIds;

    public static TrainingProgramDto fromEntity(TrainingProgram program) {
        return TrainingProgramDto.builder()
                .name(program.getName())
                .duration(program.getDuration())
                .state(program.getState())
                .feeling(program.getFeeling())
                .startDate(program.getStartDate())
                .endDate(program.getEndDate())
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
                .state(programDto.getState())
                .feeling(programDto.getFeeling())
                .startDate(programDto.getStartDate())
                .endDate(programDto.getEndDate())
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
