package com.kimdev.trackarate.dto;

import com.kimdev.trackarate.models.Role;

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
public class RoleDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 10)
    private String name;

    public static RoleDto fromEntity(Role role) {
        return RoleDto.builder()
                .name(role.getName())
                .build();
    }

    public static Role toEntity(RoleDto roleDto) {
        return Role.builder()
                .name(roleDto.getName())
                .build();
    }
}
