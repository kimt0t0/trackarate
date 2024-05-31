package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.Like;

public interface LikeRepository extends JpaRepository<Like, UUID> {
    // FIND MANY
    List<Like> findAllByUserId(UUID id);

    @Query(value = "select * from likes l inner join exercises e on l.id_exercise = e.id", nativeQuery = true)
    List<Like> findAllByExerciseId(UUID id);

    @Query(value = "select * from likes l inner join training_programs p on l.id_program = p.id", nativeQuery = true)
    List<Like> findAllByTrainingProgramId(UUID id);

    @Query(value = "select * from likes l inner join training_sessions s on l.id_session = s.id", nativeQuery = true)
    List<Like> findAllByTrainingSessionId(UUID id);

    // FIND ONE
    Like findOneById(UUID id);
}
