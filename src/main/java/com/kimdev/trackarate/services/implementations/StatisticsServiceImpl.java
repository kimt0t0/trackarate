package com.kimdev.trackarate.services.implementations;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.repositories.ExerciseRepository;
import com.kimdev.trackarate.repositories.TrainingProgramRepository;
import com.kimdev.trackarate.repositories.TrainingSessionRepository;
import com.kimdev.trackarate.services.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService {

    private final ExerciseRepository exerciseRepository;
    private final TrainingSessionRepository sessionRepository;
    private final TrainingProgramRepository programRepository;

    @Override
    public Map<LocalDate, Integer> findSumTrainingSessionsByDate(LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumTrainingSessionsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findUserSumTrainingSessionsByDate(LocalDate startDate, LocalDate endDate,
            UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserSumTrainingSessionsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findUserSumExercisesByDate(LocalDate startDate, LocalDate endDate, UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserSumExercisesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findSumLikesByDate(LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumLikesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findUserSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserSumLikesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findSumCommentsByDate(LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumCommentsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findUserSumCommentsByDate(LocalDate startDate, LocalDate endDate, UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserSumCommentsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findExerciseSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID exerciseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findExerciseSumLikesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findExerciseSumCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID exerciseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findExerciseSumCommentsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findSessionSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID sessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSessionSumLikesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findSessionSumCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID sessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSessionSumCommentsByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findProgramSumLikesByDate(LocalDate startDate, LocalDate endDate, UUID programId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProgramSumLikesByDate'");
    }

    @Override
    public Map<LocalDate, Integer> findProgramSumCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID programId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProgramSumCommentsByDate'");
    }

    @Override
    public Map<TrainingState, Integer> findSumProgramsByState(TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumProgramsByState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumProgramsByUserAndState(UUID userId, TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumProgramsByUserAndState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumProgramsByFeeling(TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumProgramsByFeeling'");
    }

    @Override
    public Map<TrainingState, Integer> findSumProgramsByUserAndFeeling(UUID userId, TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumProgramsByUserAndFeeling'");
    }

    @Override
    public Map<TrainingState, Integer> findSumSessionsByState(TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumSessionsByState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumSessionsByUserAndState(UUID userId, TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumSessionsByUserAndState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumSessionsByFeeling(TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumSessionsByFeeling'");
    }

    @Override
    public Map<TrainingState, Integer> findSumSessionsByUserAndFeeling(UUID userId, TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumSessionsByUserAndFeeling'");
    }

    @Override
    public Map<TrainingState, Integer> findSumExercisesByState(TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumExercisesByState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumExercisesByUserAndState(UUID userId, TrainingState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumExercisesByUserAndState'");
    }

    @Override
    public Map<TrainingState, Integer> findSumExercisesByFeeling(TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumExercisesByFeeling'");
    }

    @Override
    public Map<TrainingState, Integer> findSumExercisesByUserAndFeeling(UUID userId, TrainingFeeling feeling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSumExercisesByUserAndFeeling'");
    }

    @Override
    public Integer getExerciseLikesCount(UUID exerciseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExerciseLikesCount'");
    }

    @Override
    public Integer getExerciseCommentsCount(UUID exerciseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExerciseCommentsCount'");
    }

    @Override
    public Integer getSessionLikesCount(UUID sessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionLikesCount'");
    }

    @Override
    public Integer getSessionCommentsCount(UUID sessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionCommentsCount'");
    }

    @Override
    public Integer getProgramLikesCount(UUID programId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProgramLikesCount'");
    }

    @Override
    public Integer getProgramCommentsCount(UUID programId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProgramCommentsCount'");
    }

    @Override
    public Integer getUserExercisesPast(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserExercisesPast'");
    }

    @Override
    public Integer getUserSessionsPast(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserSessionsPast'");
    }

    @Override
    public Integer getUserProgramsPast(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserProgramsPast'");
    }

    @Override
    public Integer getUserProgramsCompleted(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserProgramsCompleted'");
    }

    @Override
    public Integer getUserSessionsCompleted(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserSessionsCompleted'");
    }

    @Override
    public Integer getUserExercisesCompleted(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserExercisesCompleted'");
    }

}
