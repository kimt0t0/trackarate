package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.CommentDto;

public interface CommentService extends AbstractService<CommentDto> {

    // FIND MANY
    List<CommentDto> findAllByUserId(UUID id);

    List<CommentDto> findAllPublicByUserId(UUID id);

    List<CommentDto> findAllByUserUsername(String id);

    List<CommentDto> findAllPublicByUserUsername(String id);

    List<CommentDto> findAllByExerciseId(UUID id);

    List<CommentDto> findAllPublicByExerciseId(UUID id);

    List<CommentDto> findAllByTrainingProgramId(UUID id);

    List<CommentDto> findAllPublicByTrainingProgramId(UUID id);

    List<CommentDto> findAllByTrainingSessionId(UUID id);

    List<CommentDto> findAllPublicByTrainingSessionId(UUID id);

}
