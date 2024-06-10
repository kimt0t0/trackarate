package com.kimdev.trackarate.dto;

import com.kimdev.trackarate.models.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TypeDto {

    private String name;

    public static TypeDto fromEntity(Type type) {
        return TypeDto.builder()
                .name(type.getName())
                .build();
    }

    public static Type toEntity(Type typeDto) {
        return Type.builder()
                .name(typeDto.getName())
                .build();
    }
}
