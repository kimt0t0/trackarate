package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.MediaDto;
import com.kimdev.trackarate.enums.MediaType;

public interface MediaService extends AbstractService<MediaDto> {

    // FIND MANY
    List<MediaDto> findAllPublic();

    List<MediaDto> findAllByExerciseId(UUID id);

    List<MediaDto> findAllPublicByExerciseId(UUID id);

    List<MediaDto> findAllByExerciseTitle(String title);

    List<MediaDto> findAllPublicByExerciseTitle(String title);

    List<MediaDto> findAllByTitle(String title);

    List<MediaDto> findAllPublicByTitle(String title);

    List<MediaDto> findAllByTitleAndType(String title, MediaType type);

    List<MediaDto> findAllPublicByTitleAndType(String title, MediaType type);

    List<MediaDto> findAllByTitleOrDescription(String search);

    List<MediaDto> findAllPublicByTitleOrDescription(String search);

    List<MediaDto> findAllByTitleOrDescriptionAndType(String search, MediaType type);

    List<MediaDto> findAllPublicByTitleOrDescriptionAndType(String search, MediaType type);

    // FIND ONE

    MediaDto findOnePublic(UUID id);

    MediaDto findOneByTitle(String title);

    MediaDto findOnePublicByTitle(String title);

    MediaDto findOneByTitleAndUserUsername(String title, String username);

    MediaDto findOnePublicByTitleAndUserUsername(String title, String username);

}
