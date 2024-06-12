package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.enums.MediaType;
import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.models.Media;
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
public class MediaDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 255)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 10)
    private MediaType type;

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    @NotNull
    @NotBlank
    @NotEmpty
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
