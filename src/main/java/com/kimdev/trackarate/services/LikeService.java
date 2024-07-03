package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.LikeDto;

public interface LikeService extends AbstractService<LikeDto> {

    List<LikeDto> findAllByUserId(UUID id);

    List<LikeDto> findAllPublicByUserId(UUID id);

    List<LikeDto> findAllByUserUsername(String id);

    List<LikeDto> findAllPublicByUserUsername(String id);

    List<LikeDto> findAllByExerciseId(UUID id);

    List<LikeDto> findAllPublicByExerciseId(UUID id);

    List<LikeDto> findAllByTrainingProgramId(UUID id);

    List<LikeDto> findAllPublicByTrainingProgramId(UUID id);

    List<LikeDto> findAllByTrainingSessionId(UUID id);

    List<LikeDto> findAllPublicByTrainingSessionId(UUID id);

}
