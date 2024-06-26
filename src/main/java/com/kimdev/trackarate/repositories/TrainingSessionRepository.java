package com.kimdev.trackarate.repositories;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, UUID> {

    // FIND MANY
    List<TrainingSession> findAllByUserUsername(String username);

    List<TrainingSession> findAllBySessionTypesId(UUID id);

    List<TrainingSession> findAllByDatetime(ZonedDateTime datetime);

    List<TrainingSession> findAllByDatetimeAndUserId(ZonedDateTime datetime, UUID id);

    List<TrainingSession> findAllByDatetimeAndUserIdAndUserSettingsIsPrivate(ZonedDateTime datetime, UUID id,
            boolean isPrivate);

    List<TrainingSession> findAllByDatetimeBefore(ZonedDateTime datetime);

    List<TrainingSession> findAllByDatetimeAfter(ZonedDateTime datetime);

    List<TrainingSession> findAllBySessionTypesNameContainingIgnoreCase(String name);

    List<TrainingSession> findAllByUserSettingsIsPrivateAndSessionTypesId(boolean isPrivate,
            UUID id);

    List<TrainingSession> findAllByUserSettingsIsPrivateAndSessionTypesNameContainingIgnoreCase(boolean isPrivate,
            String name);

    List<TrainingSession> findAllByUserId(UUID id);

    List<TrainingSession> findAllByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    List<TrainingSession> findAllByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(String name, UUID id,
            boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCase(String name);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsId(UUID id);

    List<TrainingSession> findAllByTrainingProgramsIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingSession> findAllByExercisesId(UUID id);

    List<TrainingSession> findAllByExercisesIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingSession> findAllByExercisesTitleContainingIgnoreCase(String title);

    List<TrainingSession> findAllByExercisesTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title,
            boolean isPrivate);

    List<TrainingSession> findAllByState(TrainingState state);

    List<TrainingSession> findAllByStateAndUserSettingsIsPrivate(TrainingState state, boolean isPrivate);

    List<TrainingSession> findAllByStateAndUserId(TrainingState state, UUID id);

    List<TrainingSession> findAllByStateAndUserIdAndUserSettingsIsPrivate(TrainingState state, UUID id,
            boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(String name,
            TrainingState state, boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndState(String name,
            TrainingState state);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingState state, UUID id, boolean isPrivate);

    List<TrainingSession> findAllByFeeling(TrainingFeeling feeling);

    List<TrainingSession> findAllByFeelingAndUserSettingsIsPrivate(TrainingFeeling feeling, boolean isPrivate);

    List<TrainingSession> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingSession> findAllByFeelingAndUserIdAndUserSettingsIsPrivate(TrainingFeeling feeling, UUID id,
            boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndFeeling(
            String name,
            TrainingFeeling feeling);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<TrainingSession> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingSession> findAllByStateAndFeelingAndUserSettingsIsPrivate(TrainingState state, TrainingFeeling feeling,
            boolean isPrivate);

    List<TrainingSession> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingSession> findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(TrainingState state,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, boolean isPrivate);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingSession> findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, UUID id, boolean isPrivate);

    // COUNT
    @Query(value = "select s.datetime, count(*) from training_sessions s where s.datetime = :datetime", nativeQuery = true)
    Map<ZonedDateTime, Integer> findCountTrainingSessionsByDate(ZonedDateTime datetime);

    @Query(value = "select s.datetime, count(*) from training_sessions s inner join users u on u.id = s.user_id  where ((u.id = :id) and (s.datetime = :datetime))", nativeQuery = true)
    Map<ZonedDateTime, Integer> findCountTrainingSessionsByDatetimeAndUserId(ZonedDateTime datetime, UUID id);

    @Query(value = "select s.datetime, count(*) from training_sessions s inner join users u inner join settings se on u.id = s.user_id and u.id = se.user_id where ((u.id = :id) and (se.isPrivate = :isPrivate) and (s.datetime = :datetime))", nativeQuery = true)
    Map<ZonedDateTime, Integer> findCountTrainingSessionsByDatetimeAndUserIdAndUserSettingsIsPrivate(
            ZonedDateTime datetime, UUID id,
            boolean isPrivate);

    @Query(value = "select state, count(*) from training_sessions", nativeQuery = true)
    Map<TrainingState, Integer> findCountSessionsByState();

    @Query(value = "select state, count(*) from training_sessions s inner join users u on s.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountSessionsByUserAndState(UUID userId);

    @Query(value = "select feeling, count(*) from training_sessions", nativeQuery = true)
    Map<TrainingState, Integer> findCountSessionsByFeeling();

    @Query(value = "select feeling, count(*) from training_sessions s inner join users u on s.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountSessionsByUserAndFeeling(UUID userId);

    // FIND ONE
    Optional<TrainingSession> findOneById(UUID id);

    Optional<TrainingSession> findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Optional<TrainingSession> findOneByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    Optional<TrainingSession> findOneByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(String name, UUID id,
            boolean isPrivate);

    Optional<TrainingSession> findOneByCommentsId(UUID commentId);

    Optional<TrainingSession> findOneByLikesId(UUID likeId);

    Optional<TrainingSession> findOneByCommentsIdAndUserSettingsIsPrivate(UUID commentId, boolean isPrivate);

    Optional<TrainingSession> findOneByLikesIdAndUserSettingsIsPrivate(UUID likeId, boolean isPrivate);
}
