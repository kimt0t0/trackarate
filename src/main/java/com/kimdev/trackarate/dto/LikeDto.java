package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.Like;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.models.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LikeDto {

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    private UUID exerciseId;

    private UUID trainingProgramId;

    private UUID trainingSessionId;

    public static LikeDto fromEntity(Like like) {
        return LikeDto.builder()
                .userId(like.getUser().getId())
                .exerciseId(like.getExercise().getId())
                .trainingProgramId(like.getTrainingProgram().getId())
                .trainingSessionId(like.getTrainingSession().getId())
                .build();
    }

    public static Like toEntity(LikeDto likeDto) {
        return Like.builder()
                .user(
                        User.builder()
                                .id(likeDto.userId)
                                .build())
                .exercise(
                        Exercise.builder()
                                .id(likeDto.exerciseId)
                                .build())
                .trainingProgram(
                        TrainingProgram.builder()
                                .id(likeDto.trainingProgramId)
                                .build())
                .trainingSession(
                        TrainingSession.builder()
                                .id(likeDto.trainingSessionId)
                                .build())
                .build();
    }

}
