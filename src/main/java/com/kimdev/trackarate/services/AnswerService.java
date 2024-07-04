package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.AnswerDto;

public interface AnswerService extends AbstractService<AnswerDto> {

    // FIND MANY
    List<AnswerDto> findAllPublic();

    List<AnswerDto> findAllByUserUsername(String username);

    List<AnswerDto> findAllPublicByUserUsername(String username);

    List<AnswerDto> findAllByUserId(UUID id);

    List<AnswerDto> findAllPublicByUserId(UUID id);

    List<AnswerDto> findAllByQuestionId(UUID id);

    List<AnswerDto> findAllPublicByQuestionId(UUID id);

    // FIND ONE

    AnswerDto findOneByTextSearch(String search);

    AnswerDto findOnePublicByTextSearch(String search);

}
