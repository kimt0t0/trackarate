package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Avatar;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AvatarDto {

    private String path;

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
