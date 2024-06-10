package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.TrainingProgram;
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

    public static TrainingProgramDto fromEntity(TrainingProgram program) {
        return TrainingProgramDto.builder()
                .name(program.getName())
                .duration(program.getDuration())
                .userId(program.getUser().getId())
                .build();
    }

    public static TrainingProgram toEntity(TrainingProgramDto programDto) {
        return TrainingProgram.builder()
                .name(programDto.getName())
                .duration(programDto.getDuration())
                .user(
                        User.builder()
                                .id(programDto.userId)
                                .build())
                .build();
    }
}
