package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Settings;
import com.kimdev.trackarate.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SettingsDto {

    private boolean isPrivate;

    private boolean isEvaluateTrainingsPerWeek;

    private Integer trainingsPerWeek;

    private boolean isEvaluateTrainingsAverageDuration;

    private Integer trainingsAverageDuration;

    private String beltOrGrade;

    private String goals;

    private UUID userId;

    public static SettingsDto fromEntity(Settings settings) {
        return SettingsDto.builder()
                .isPrivate(settings.isPrivate())
                .isEvaluateTrainingsPerWeek(settings.isEvaluateTrainingsPerWeek())
                .trainingsPerWeek(settings.getTrainingsPerWeek())
                .isEvaluateTrainingsAverageDuration(settings.isEvaluateTrainingsAverageDuration())
                .trainingsAverageDuration(settings.getTrainingsAverageDuration())
                .beltOrGrade(settings.getBeltOrGrade())
                .goals(settings.getGoals())
                .userId(settings.getUser().getId())
                .build();
    }

    public static Settings toEntity(SettingsDto settingsDto) {
        return Settings.builder()
                .isPrivate(settingsDto.isPrivate())
                .isEvaluateTrainingsPerWeek(settingsDto.isEvaluateTrainingsPerWeek())
                .trainingsPerWeek(settingsDto.getTrainingsPerWeek())
                .isEvaluateTrainingsAverageDuration(settingsDto.isEvaluateTrainingsAverageDuration())
                .trainingsAverageDuration(settingsDto.getTrainingsAverageDuration())
                .beltOrGrade(settingsDto.getBeltOrGrade())
                .goals(settingsDto.getGoals())
                .user(
                        User.builder()
                                .id(settingsDto.userId)
                                .build())
                .build();
    }

}
