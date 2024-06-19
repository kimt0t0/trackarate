package com.kimdev.trackarate.services;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

public interface StatisticsService {

    Map<LocalDate, Integer> findSumTrainingSessionsByDate(LocalDate startDate, LocalDate endDate);

    Map<LocalDate, Integer> findUserSumTrainingSessionsByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findUserSumExercisesByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findSumLikesByDate(LocalDate startDate, LocalDate endDate);

    Map<LocalDate, Integer> findUserSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findSumCommentsByDate(LocalDate startDate, LocalDate endDate);

    Map<LocalDate, Integer> findUserSumCommentsByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    Map<LocalDate, Integer> findExerciseSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID exerciseId);

    Map<LocalDate, Integer> findExerciseSumCommentsByDate(LocalDate startDate, LocalDate endDate, UUID exerciseId);

    Map<LocalDate, Integer> findSessionSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID sessionId);

    Map<LocalDate, Integer> findSessionSumCommentsByDate(LocalDate startDate, LocalDate endDate, UUID sessionId);

    Map<LocalDate, Integer> findProgramSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID programId);

    Map<LocalDate, Integer> findProgramSumCommentsByDate(LocalDate startDate, LocalDate endDate, UUID programId);

    Map<TrainingState, Integer> findSumProgramsByState(TrainingState state);

    Map<TrainingState, Integer> findSumProgramsByUserAndState(UUID userId, TrainingState state);

    Map<TrainingState, Integer> findSumProgramsByFeeling(TrainingFeeling feeling);

    Map<TrainingState, Integer> findSumProgramsByUserAndFeeling(UUID userId, TrainingFeeling feeling);

    Map<TrainingState, Integer> findSumSessionsByState(TrainingState state);

    Map<TrainingState, Integer> findSumSessionsByUserAndState(UUID userId, TrainingState state);

    Map<TrainingState, Integer> findSumSessionsByFeeling(TrainingFeeling feeling);

    Map<TrainingState, Integer> findSumSessionsByUserAndFeeling(UUID userId, TrainingFeeling feeling);

    Map<TrainingState, Integer> findSumExercisesByState(TrainingState state);

    Map<TrainingState, Integer> findSumExercisesByUserAndState(UUID userId, TrainingState state);

    Map<TrainingState, Integer> findSumExercisesByFeeling(TrainingFeeling feeling);

    Map<TrainingState, Integer> findSumExercisesByUserAndFeeling(UUID userId, TrainingFeeling feeling);

    //

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
