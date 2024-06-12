package com.kimdev.trackarate.dto;

import java.util.UUID;

import com.kimdev.trackarate.models.Settings;
import com.kimdev.trackarate.models.User;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SettingsDto {

    @NotNull
    @NotBlank
    @NotEmpty
    private boolean isPrivate;

    private boolean isEvaluateTrainingsPerWeek;

    @Positive
    @Max(20)
    private Integer trainingsPerWeek;

    private boolean isEvaluateTrainingsAverageDuration;

    @Positive
    @Min(5)
    @Max(300)
    private Integer trainingsAverageDuration;

    @Size(max = 10)
    private String beltOrGrade;

    @Size(max = 500)
    private String goals;

    @NotNull
    @NotBlank
    @NotEmpty
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
