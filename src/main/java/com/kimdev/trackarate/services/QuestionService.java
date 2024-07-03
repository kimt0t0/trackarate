package com.kimdev.trackarate.services;

import java.util.List;

import com.kimdev.trackarate.dto.QuestionDto;

public interface QuestionService extends AbstractService<QuestionDto> {

    List<QuestionDto> findAllByTitle(String title);

    List<QuestionDto> findAllPublicByTitle(String title);

    List<QuestionDto> findAllByTitleOrDetails(String title, String details);

    List<QuestionDto> findAllPublicByTitleOrDetails(String title, String details);
}
