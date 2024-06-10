package com.kimdev.trackarate.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.kimdev.trackarate.models.TrainingSession;
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

    public static TrainingSessionDto fromEntity(TrainingSession session) {
        return TrainingSessionDto.builder()
                .name(session.getName())
                .duration(session.getDuration())
                .datetime(session.getDatetime())
                .userId(session.getUser().getId())
                .build();
    }

    public static TrainingSession toEntity(TrainingSessionDto sessionDto) {
        return TrainingSession.builder()
                .name(sessionDto.getName())
                .duration(sessionDto.getDuration())
                .datetime(sessionDto.getDatetime())
                .user(
                        User.builder()
                                .id(sessionDto.userId)
                                .build())
                .build();
    }
}
