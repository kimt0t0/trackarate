package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Question;
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
public class QuestionDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 255)
    private String title;

    @Size(max = 2000)
    private String details;

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    public static QuestionDto fromEntity(Question question) {
        return QuestionDto.builder()
                .title(question.getTitle())
                .details(question.getDetails())
                .userId(question.getUser().getId())
                .build();
    }

    public static Question toEntity(QuestionDto questionDto) {
        return Question.builder()
                .title(questionDto.getTitle())
                .details(questionDto.getDetails())
                .user(
                        User.builder()
                                .id(questionDto.userId)
                                .build())
                .build();
    }

}
