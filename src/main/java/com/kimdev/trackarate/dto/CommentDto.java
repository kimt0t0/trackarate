package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Comment;
import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.models.TrainingSession;
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
public class CommentDto {

    @Size(max = 120)
    private String title;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 2000)
    private String text;

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    private UUID exerciseId;

    private UUID trainingProgramId;

    private UUID trainingSessionId;

    public static CommentDto fromEntity(Comment comment) {
        return CommentDto.builder()
                .title(comment.getTitle())
                .text(comment.getText())
                .userId(comment.getUser().getId())
                .exerciseId(comment.getExercise().getId())
                .trainingProgramId(comment.getTrainingProgram().getId())
                .trainingSessionId(comment.getTrainingSession().getId())
                .build();
    }

    public static Comment toEntity(CommentDto commentDto) {
        return Comment.builder()
                .title(commentDto.getTitle())
                .text(commentDto.getText())
                .user(
                        User.builder()
                                .id(commentDto.userId)
                                .build())
                .exercise(
                        Exercise.builder()
                                .id(commentDto.exerciseId)
                                .build())
                .trainingProgram(
                        TrainingProgram.builder()
                                .id(commentDto.trainingProgramId)
                                .build())
                .trainingSession(
                        TrainingSession.builder()
                                .id(commentDto.trainingSessionId)
                                .build())
                .build();
    }

}
