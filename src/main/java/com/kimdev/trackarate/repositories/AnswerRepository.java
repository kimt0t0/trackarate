package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Answer;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    // FIND MANY
    List<Answer> findAll();

    List<Answer> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<Answer> findAllByUserUsernameContainingIgnoreCase(String username);

    List<Answer> findAllByUserUsernameContainingIgnoreCaseAndUserSettingsIsPrivate(String username, boolean isPrivate);

    List<Answer> findAllByUserId(UUID id);

    List<Answer> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Answer> findAllByQuestionId(UUID id);

    // FIND ONE
    Answer findOneById(UUID id);
}
