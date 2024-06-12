package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Avatar;
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
public class AvatarDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 255)
    private String path;

    @NotNull
    @NotBlank
    @NotEmpty
    private UUID userId;

    public static AvatarDto fromEntity(Avatar avatar) {
        return AvatarDto.builder()
                .path(avatar.getPath())
                .userId(avatar.getUser().getId())
                .build();
    }

    public static Avatar toEntity(AvatarDto avatarDto) {
        return Avatar.builder()
                .path(avatarDto.getPath())
                .user(
                        User.builder()
                                .id(avatarDto.userId)
                                .build())
                .build();
    }

}
