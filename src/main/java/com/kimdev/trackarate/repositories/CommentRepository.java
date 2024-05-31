package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    // FIND MANY
    List<Comment> findAllByUserId(UUID id);

    List<Comment> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Comment> findAllByUserUsername(String id);

    List<Comment> findAllByUserUsernameAndUserSettingsIsPrivate(String id, boolean isPrivate);

    List<Comment> findAllByExerciseId(UUID id);

    List<Comment> findAllByExerciseIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Comment> findAllByTrainingProgramId(UUID id);

    List<Comment> findAllByTrainingProgramIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Comment> findAllByTrainingSessionId(UUID id);

    List<Comment> findAllByTrainingSessionIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    // FIND ONE
    Comment findOneById(UUID id);
}
