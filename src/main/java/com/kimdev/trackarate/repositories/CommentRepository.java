package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    // FIND MANY
    List<Comment> findAllByUserId(UUID id);

    @Query(value = "select * from comments c inner join exercises e on c.id_exercise = e.id", nativeQuery = true)
    List<Comment> findAllByExerciseId(UUID id);

    @Query(value = "select * from comments c inner join training_programs p on c.id_program = p.id", nativeQuery = true)
    List<Comment> findAllByTrainingProgramId(UUID id);

    @Query(value = "select * from comments c inner join training_sessions s on c.id_session = s.id", nativeQuery = true)
    List<Comment> findAllByTrainingSessionId(UUID id);

    // FIND ONE
    Comment findOneById(UUID id);
}
