package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, UUID> {
    // FIND MANY
    List<TrainingProgram> findAll();

    List<TrainingProgram> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<TrainingProgram> findAllByUserId(UUID id);

    List<TrainingProgram> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByUserUsernameContainingIgnoreCase(String username);

    List<TrainingProgram> findAllByUserUsernameContainingIgnoreCaseAndUserSettingsIsPrivate(String username,
            boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCase(String name);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<TrainingProgram> findAllByTrainingSessionsId(UUID id);

    List<TrainingProgram> findAllByTrainingSessionsIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByTrainingSessionsNameContainingIgnoreCase(String name);

    List<TrainingProgram> findAllByTrainingSessionsNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    // FIND ONE
    TrainingProgram findOneById(UUID id);

    TrainingProgram findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    TrainingProgram findOneByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    TrainingProgram findOneByCommentsId(UUID commentId);

    TrainingProgram findOneByLikesId(UUID likeId);

    TrainingProgram findOneByCommentsIdAndUserSettingsIsPrivate(UUID commentId, boolean isPrivate);

    TrainingProgram findOneByLikesIdAndUserSettingsIsPrivate(UUID likeId, boolean isPrivate);
}
