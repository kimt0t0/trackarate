package com.kimdev.trackarate.services.implementations;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.repositories.CommentRepository;
import com.kimdev.trackarate.repositories.ExerciseRepository;
import com.kimdev.trackarate.repositories.LikeRepository;
import com.kimdev.trackarate.repositories.TrainingProgramRepository;
import com.kimdev.trackarate.repositories.TrainingSessionRepository;
import com.kimdev.trackarate.repositories.UserRepository;
import com.kimdev.trackarate.services.StatisticsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final CommentRepository commentRepository;
    private final ExerciseRepository exerciseRepository;
    private final LikeRepository likeRepository;
    private final TrainingSessionRepository sessionRepository;
    private final TrainingProgramRepository programRepository;
    private final UserRepository userRepository;

    @Override
    public Map<ZonedDateTime, Integer> findCountTrainingSessionsByDate(ZonedDateTime datetime) {
        return sessionRepository.findCountTrainingSessionsByDate(datetime);
    }

    @Override
    public Map<ZonedDateTime, Integer> findUserCountTrainingSessionsByDate(
            ZonedDateTime datetime,
            UUID userId) {
        return sessionRepository.findCountTrainingSessionsByDatetimeAndUserId(datetime, userId);
    }

    @Override
    public Map<ZonedDateTime, Integer> findUserCountExercisesByDate(ZonedDateTime datetime, UUID userId) {
        return exerciseRepository.findUserCountExercisesByDate(datetime, userId);
    }

    @Override
    public Map<LocalDate, Integer> findCountLikesByDate(LocalDate startDate, LocalDate endDate) {
        return likeRepository.findCountLikesByDate(startDate, endDate);
    }

    @Override
    public Map<LocalDate, Integer> findUserCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID userId) {
        return likeRepository.findUserCountLikesByDate(startDate, endDate, userId);
    }

    @Override
    public Map<LocalDate, Integer> findCountCommentsByDate(LocalDate startDate, LocalDate endDate) {
        return commentRepository.findCountCommentsByDate(startDate, endDate);
    }

    @Override
    public Map<LocalDate, Integer> findUserCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID userId) {
        return commentRepository.findUserCountCommentsByDate(startDate, endDate, userId);
    }

    @Override
    public Map<LocalDate, Integer> findExerciseCountLikesByDate(LocalDate startDate, LocalDate endDate,
            UUID exerciseId) {
        return likeRepository.findExerciseCountLikesByDate(startDate, endDate, exerciseId);
    }

    @Override
    public Map<LocalDate, Integer> findExerciseCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID exerciseId) {
        return commentRepository.findExerciseCountCommentsByDate(startDate, endDate, exerciseId);
    }

    @Override
    public Map<LocalDate, Integer> findSessionCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID sessionId) {
        return likeRepository.findSessionCountLikesByDate(startDate, endDate, sessionId);
    }

    @Override
    public Map<LocalDate, Integer> findSessionCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID sessionId) {
        return commentRepository.findSessionCountCommentsByDate(startDate, endDate, sessionId);
    }

    @Override
    public Map<LocalDate, Integer> findProgramCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID programId) {
        return likeRepository.findProgramCountLikesByDate(startDate, endDate, programId);
    }

    @Override
    public Map<LocalDate, Integer> findProgramCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID programId) {
        return commentRepository.findProgramCountCommentsByDate(startDate, endDate, programId);
    }

    @Override
    public Map<TrainingState, Integer> findCountProgramsByState() {
        return programRepository.findCountProgramsByState();
    }

    @Override
    public Map<TrainingState, Integer> findCountProgramsByUserAndState(UUID userId) {
        return programRepository.findCountProgramsByUserAndState(userId);
    }

    @Override
    public Map<TrainingState, Integer> findCountProgramsByFeeling() {
        return programRepository.findCountProgramsByFeeling();
    }

    @Override
    public Map<TrainingState, Integer> findCountProgramsByUserAndFeeling(UUID userId) {
        return programRepository.findCountProgramsByUserAndFeeling(userId);
    }

    @Override
    public Map<TrainingState, Integer> findCountSessionsByState() {
        return sessionRepository.findCountSessionsByState();
    }

    @Override
    public Map<TrainingState, Integer> findCountSessionsByUserAndState(UUID userId) {
        return sessionRepository.findCountSessionsByUserAndState(userId);
    }

    @Override
    public Map<TrainingState, Integer> findCountSessionsByFeeling() {
        return sessionRepository.findCountSessionsByFeeling();
    }

    @Override
    public Map<TrainingState, Integer> findCountSessionsByUserAndFeeling(UUID userId) {
        return sessionRepository.findCountSessionsByUserAndFeeling(userId);
    }

    @Override
    public Map<TrainingState, Integer> findCountExercisesByState() {
        return exerciseRepository.findCountExercisesByState();
    }

    @Override
    public Map<TrainingState, Integer> findCountExercisesByUserAndState(UUID userId) {
        return exerciseRepository.findCountExercisesByUserAndState(userId);
    }

    @Override
    public Map<TrainingState, Integer> findCountExercisesByFeeling() {
        return exerciseRepository.findCountExercisesByFeeling();
    }

    @Override
    public Map<TrainingState, Integer> findCountExercisesByUserAndFeeling(UUID userId) {
        return exerciseRepository.findCountExercisesByUserAndFeeling(userId);
    }

    @Override
    public Integer getUsersCount() {
        return userRepository.getUsersCount();
    }

    @Override
    public Integer getUsersCountByRole(UUID roleId) {
        return userRepository.getUsersCountByRole(roleId);
    }

    @Override
    public Integer getExerciseLikesCount(UUID exerciseId) {
        return likeRepository.findAllByExerciseId(exerciseId).size();
    }

    @Override
    public Integer getExerciseCommentsCount(UUID exerciseId) {
        return commentRepository.findAllByExerciseId(exerciseId).size();
    }

    @Override
    public Integer getSessionLikesCount(UUID sessionId) {
        return likeRepository.findAllByTrainingSessionId(sessionId).size();
    }

    @Override
    public Integer getSessionCommentsCount(UUID sessionId) {
        return commentRepository.findAllByTrainingSessionId(sessionId).size();
    }

    @Override
    public Integer getProgramLikesCount(UUID programId) {
        return likeRepository.findAllByTrainingProgramId(programId).size();
    }

    @Override
    public Integer getProgramCommentsCount(UUID programId) {
        return commentRepository.findAllByTrainingProgramId(programId).size();
    }

    @Override
    public Integer getExercisesCompletedCount() {
        return exerciseRepository.findAllByState(TrainingState.DONE).size();
    };

    @Override
    public Integer getSessionsPastCount() {
        ZonedDateTime now = ZonedDateTime.now();
        return sessionRepository.findAllByDatetimeBefore(now).size();
    };

    @Override
    public Integer getProgramsPastCount() {
        Date now = new Date();
        return programRepository.findAllByEndDateBefore(now).size();
    };

    @Override
    public Integer getUserSessionsPastCount(UUID userId) {
        return sessionRepository.findAllByStateAndUserId(TrainingState.DONE, userId).size();
    }

    @Override
    public Integer getUserProgramsPastCount(UUID userId) {
        return programRepository.findAllByStateAndUserId(TrainingState.DONE, userId).size();
    }

    @Override
    public Integer getUserProgramsCompletedCount(UUID userId) {
        return programRepository.findAllByStateAndUserId(TrainingState.DONE, userId).size();
    }

    @Override
    public Integer getUserSessionsCompletedCount(UUID userId) {
        return sessionRepository.findAllByStateAndUserId(TrainingState.DONE, userId).size();
    }

    @Override
    public Integer getUserExercisesCompletedCount(UUID userId) {
        return exerciseRepository.findAllByStateAndUserId(TrainingState.DONE, userId).size();
    }

}
