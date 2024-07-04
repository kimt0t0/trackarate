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
import com.kimdev.trackarate.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
    // GET MANY
    List<Exercise> findAll();

    List<Exercise> findAllByUserId(UUID id);

    List<Exercise> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Exercise> findAllByUserUsername(String username);

    List<Exercise> findAllByUserUsernameAndUserSettingsIsPrivate(String username, boolean isPrivate);

    List<Exercise> findAllByUserIdAndTitleContainingIgnoreCase(UUID id, String title);

    List<Exercise> findAllByUserIdAndTitleContainingIgnoreCaseAndUserSettingsIsPrivate(UUID id,
            String title, boolean IsPrivate);

    List<Exercise> findAllByTitleContainingIgnoreCase(String title);

    List<Exercise> findAllByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title, boolean IsPrivate);

    @Query(value = "select * from exercises e inner join user u inner join settings s on e.user_id = u.id and s.user_id = u.id and (((e.title ilike %:search%) or (e.description ilike %search%)) and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<Exercise> findAllBySearchInTitleAndDescriptionAndUserSettingsIsPrivate(String search, boolean isPrivate);

    @Query(value = "select * from exercises where ((title ilike %:search%) or (description ilike %search%))", nativeQuery = true)
    List<Exercise> findAllBySearchInTitleAndDescription(String search);

    List<Exercise> findAllByExerciseTypesNameContainingIgnoreCase(String name);

    List<Exercise> findAllByExerciseTypesNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsId(UUID sessionId);

    List<Exercise> findAllByTrainingSessionsIdAndUserSettingsIsPrivate(UUID sessionId, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCase(String name);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(String name,
            TrainingState state, boolean isPrivate);

    List<Exercise> findAllByState(TrainingState state);

    List<Exercise> findAllByStateAndUserSettingsIsPrivate(TrainingState state, boolean isPrivate);

    List<Exercise> findAllByStateAndUserId(TrainingState state, UUID id);

    List<Exercise> findAllByStateAndUserIdAndUserSettingsIsPrivate(TrainingState state, UUID id, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingState state, UUID id, boolean isPrivate);

    List<Exercise> findAllByFeeling(TrainingFeeling feeling);

    List<Exercise> findAllByFeelingAndUserSettingsIsPrivate(TrainingFeeling feeling, boolean isPrivate);

    List<Exercise> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByFeelingAndUserIdAndUserSettingsIsPrivate(TrainingFeeling feeling, UUID id,
            boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<Exercise> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<Exercise> findAllByStateAndFeelingAndUserSettingsIsPrivate(TrainingState state, TrainingFeeling feeling,
            boolean isPrivate);

    List<Exercise> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(TrainingState state,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, UUID id, boolean isPrivate);

    // COUNT
    @Query(value = "select s.datetime, count(e) from exercise e inner join training_sessions s inner join user u on e.session_id = s.id and session.user_id = u.id where((u.id = :userId) and (s.datetime = :datetime))", nativeQuery = true)
    Map<ZonedDateTime, Integer> findUserCountExercisesByDate(ZonedDateTime datetime, UUID userId);

    //
    @Query(value = "select state, count(*) from exercises", nativeQuery = true)
    Map<TrainingState, Integer> findCountExercisesByState();

    @Query(value = "select state, count(*) from exercises e inner join users u on e.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountExercisesByUserAndState(UUID userId);

    @Query(value = "select feeling, count(*) from exercises", nativeQuery = true)
    Map<TrainingState, Integer> findCountExercisesByFeeling();

    @Query(value = "select feeling, count(*) from exercises e inner join users u on e.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountExercisesByUserAndFeeling(UUID userId);

    // GET ONE
    Optional<Exercise> findOneById(UUID id);

    Optional<Exercise> findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Optional<Exercise> findOneByTitleContainingIgnoreCaseAndUserId(String title, UUID id);

    Optional<Exercise> findOneByMediaListExerciseId(UUID id);

}
