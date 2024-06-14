package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, UUID> {

    // FIND MANY
    List<TrainingSession> findAllByUserUsername(String username);

    List<TrainingSession> findAllBySessionTypesId(UUID id);

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

    // FIND ONE
    TrainingSession findOneById(UUID id);

    TrainingSession findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    TrainingSession findOneByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    TrainingSession findOneByCommentsId(UUID commentId);

    TrainingSession findOneByLikesId(UUID likeId);

    TrainingSession findOneByCommentsIdAndUserSettingsIsPrivate(UUID commentId, boolean isPrivate);

    TrainingSession findOneByLikesIdAndUserSettingsIsPrivate(UUID likeId, boolean isPrivate);
}
