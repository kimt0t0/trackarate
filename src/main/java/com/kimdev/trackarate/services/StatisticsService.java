package com.kimdev.trackarate.services;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

import com.kimdev.trackarate.enums.TrainingState;

public interface StatisticsService {

    Map<ZonedDateTime, Integer> findCountTrainingSessionsByDate(ZonedDateTime datetime);

    Map<ZonedDateTime, Integer> findUserCountTrainingSessionsByDate(ZonedDateTime datetime, UUID userId);

    Map<ZonedDateTime, Integer> findUserCountExercisesByDate(ZonedDateTime datetime, UUID userId);

    Map<LocalDate, Integer> findCountLikesByDate(LocalDate startDate, LocalDate endDate);

    Map<LocalDate, Integer> findUserCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findCountCommentsByDate(LocalDate startDate, LocalDate endDate);

    Map<LocalDate, Integer> findUserCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findExerciseCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID exerciseId);

    Map<LocalDate, Integer> findExerciseCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID exerciseId);

    Map<LocalDate, Integer> findSessionCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID sessionId);

    Map<LocalDate, Integer> findSessionCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID sessionId);

    Map<LocalDate, Integer> findProgramCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID programId);

    Map<LocalDate, Integer> findProgramCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID programId);

    Map<TrainingState, Integer> findCountProgramsByState();

    Map<TrainingState, Integer> findCountProgramsByUserAndState(UUID userId);

    Map<TrainingState, Integer> findCountProgramsByFeeling();

    Map<TrainingState, Integer> findCountProgramsByUserAndFeeling(UUID userId);

    Map<TrainingState, Integer> findCountSessionsByState();

    Map<TrainingState, Integer> findCountSessionsByUserAndState(UUID userId);

    Map<TrainingState, Integer> findCountSessionsByFeeling();

    Map<TrainingState, Integer> findCountSessionsByUserAndFeeling(UUID userId);

    Map<TrainingState, Integer> findCountExercisesByState();

    Map<TrainingState, Integer> findCountExercisesByUserAndState(UUID userId);

    Map<TrainingState, Integer> findCountExercisesByFeeling();

    Map<TrainingState, Integer> findCountExercisesByUserAndFeeling(UUID userId);

    //

    Integer getUsersCount();

    Integer getUsersCountByRole(UUID roleId);

    Integer getExerciseLikesCount(UUID exerciseId);

    Integer getExerciseCommentsCount(UUID exerciseId);

    Integer getSessionLikesCount(UUID sessionId);

    Integer getSessionCommentsCount(UUID sessionId);

    Integer getProgramLikesCount(UUID programId);

    Integer getProgramCommentsCount(UUID programId);

    Integer getExercisesCompletedCount();

    Integer getSessionsPastCount();

    Integer getProgramsPastCount();

    Integer getUserSessionsPastCount(UUID userId);

    Integer getUserProgramsPastCount(UUID userId);

    Integer getUserProgramsCompletedCount(UUID userId);

    Integer getUserSessionsCompletedCount(UUID userId);

    Integer getUserExercisesCompletedCount(UUID userId);

}
