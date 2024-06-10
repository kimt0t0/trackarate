package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.enums.MediaType;
import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.Media;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MediaDto {

    private String title;

    private String description;

    private MediaType type;

    private UUID userId;

    private String path;

    private UUID exerciseId;

    public static MediaDto fromEntity(Media media) {
        return MediaDto.builder()
                .title(media.getTitle())
                .description(media.getDescription())
                .type(media.getType())
                .userId(media.getUser().getId())
                .path(media.getPath())
                .exerciseId(media.getExercise().getId())
                .build();
    }

    public static Media toEntity(MediaDto mediaDto) {
        return Media.builder()
                .title(mediaDto.getTitle())
                .description(mediaDto.getDescription())
                .type(mediaDto.getType())
                .user(
                        User.builder()
                                .id(mediaDto.userId)
                                .build())
                .path(mediaDto.getPath())
                .exercise(
                        Exercise.builder()
                                .id(mediaDto.exerciseId)
                                .build())
                .build();
    }

}
