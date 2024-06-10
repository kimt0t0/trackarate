package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Answer;
import com.kimdev.trackarate.models.Question;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AnswerDto {

    private String text;

    private UUID userId;

    private UUID questionId;

    public static AnswerDto fromEntity(Answer answer) {
        return AnswerDto.builder()
                .text(answer.getText())
                .userId(answer.getUser().getId())
                .questionId(answer.getQuestion().getId())
                .build();
    }

    public static Answer toEntity(AnswerDto answerDto) {
        return Answer.builder()
                .text(answerDto.getText())
                .user(
                        User.builder()
                                .id(answerDto.userId)
                                .build())
                .question(
                        Question.builder()
                                .id(answerDto.questionId)
                                .build())
                .build();
    }

}
