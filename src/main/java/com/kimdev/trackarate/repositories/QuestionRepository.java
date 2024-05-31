package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    // FIND MANY
    List<Question> findAll();

    List<Question> findAllByTitleContainingIgnoreCase(String title);

    List<Question> findAllByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(String title, String details);

    List<Question> findAllByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCaseOrAnswersTextContainingIgnoreCase(
            String title, String details, String text);

    List<Question> findAllByUserId(UUID id);

}
