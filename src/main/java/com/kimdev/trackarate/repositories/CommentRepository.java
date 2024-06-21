package com.kimdev.trackarate.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query(value = "select count(*) from comments c where c.createdDate between :startDate and :endDate", nativeQuery = true)
    Map<LocalDate, Integer> findCountCommentsByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "select count(*) from comments c inner join users u on u.id = c.user_id where((u.id = :userId) and ( c.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findUserCountCommentsByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    @Query(value = "select count(c) from comments c inner join exercises e on c.exercise_id = e.id where ((e.id = :exerciseId) and (c.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findExerciseCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID exerciseId);

    @Query(value = "select count(c) from comments c inner join training_sessions s on c.exercise_id = s.id where ((s.id = :sessionId) and (c.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findSessionCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID sessionId);

    @Query(value = "select count(c) from comments c inner join training_programs p on c.exercise_id = p.id where ((p.id = :programId) and (c.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findProgramCountCommentsByDate(LocalDate startDate, LocalDate endDate,
            UUID programId);

    // FIND ONE
    Comment findOneById(UUID id);
}
