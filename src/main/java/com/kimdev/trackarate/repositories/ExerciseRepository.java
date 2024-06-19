package com.kimdev.trackarate.repositories;

import java.util.List;
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

    List<Exercise> findAllByUserUsername(String username);

    List<Exercise> findAllByUserUsernameAndUserSettingsIsPrivate(String username, boolean isPrivate);

    List<Exercise> findAllByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title, boolean IsPrivate);

    @Query(value = "select * from exercises e inner join user u inner join settings s on e.user_id = u.id and s.user_id = u.id and (((e.title ilike %:search%) or (e.description ilike %search%)) and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<Exercise> findAllBySearchInTitleAndDescriptionAndUserSettingsIsPrivate(String search, boolean isPrivate);

    @Query(value = "select * from exercises where ((title ilike %:search%) or (description ilike %search%))", nativeQuery = true)
    List<Exercise> findAllBySearchInTitleAndDescription(String search);

    List<Exercise> findAllByUserSettingsIsPrivateAndExerciseTypesNameContainingIgnoreCase(boolean isPrivate,
            String name);

    List<Exercise> findAllByTrainingSessionsId(UUID sessionId);

    List<Exercise> findAllByTrainingSessionsName(String name);

    List<Exercise> findAllByStateAndUserSettingsIsPrivate(TrainingState state, boolean isPrivate);

    List<Exercise> findAllByStateAndUserId(TrainingState state, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(String name,
            TrainingState state, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<Exercise> findAllByFeelingAndUserSettingsIsPrivate(TrainingFeeling feeling, boolean isPrivate);

    List<Exercise> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByStateAndFeelingAndUserSettingsIsPrivate(TrainingState state, TrainingFeeling feeling,
            boolean isPrivate);

    List<Exercise> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, boolean isPrivate);

    List<Exercise> findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    // GET ONE
    Exercise findOneById(UUID id);

    Exercise findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Exercise findOneByTitleContainingIgnoreCaseAndUserId(String title, UUID id);

    Exercise findOneByMediaListExerciseId(UUID id);

    Exercise findOneByCommentsId(UUID commentId);

    Exercise findOneByLikesId(UUID likeId);

    Exercise findOneByCommentsIdAndUserSettingsIsPrivate(UUID commentId, boolean isPrivate);

    Exercise findOneByLikesIdAndUserSettingsIsPrivate(UUID likeId, boolean isPrivate);
}
