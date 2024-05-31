package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Like;

public interface LikeRepository extends JpaRepository<Like, UUID> {
    // FIND MANY
    List<Like> findAllByUserId(UUID id);

    List<Like> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByUserUsername(String id);

    List<Like> findAllByUserUsernameAndUserSettingsIsPrivate(String id, boolean isPrivate);

    List<Like> findAllByExerciseId(UUID id);

    List<Like> findAllByExerciseIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByTrainingProgramId(UUID id);

    List<Like> findAllByTrainingProgramIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByTrainingSessionId(UUID id);

    List<Like> findAllByTrainingSessionIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    // FIND ONE
    Like findOneById(UUID id);
}
