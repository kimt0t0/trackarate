package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    List<Answer> findAllByQuestionIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    // FIND ONE
    Optional<Answer> findOneById(UUID id);

    @Query(value = "select * from answers where text ilike %:search%", nativeQuery = true)
    Optional<Answer> findOneByTextSearch(String search);

    @Query(value = "select * from answers a inner join users u inner join settings s on u.id = a.user_id and u.id = s.user_id where ((a.text ilike %:search%) and s.isPrivate = :isPrivate)", nativeQuery = true)
    Optional<Answer> findOneByTextSearchAndUserSettingsIsPrivate(String search, boolean isPrivate);
}
