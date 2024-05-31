package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, UUID> {

    // FIND MANY
    List<TrainingSession> findAllByUserUsername(String username);

    List<TrainingSession> findAllByUserSettingsIsPrivateAndSessionTypesNameContainingIgnoreCase(boolean isPrivate,
            String type);

    List<TrainingSession> findAllByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    @Query(value = "select * from training_sessions s inner join training_programs p on s.program_id = p.id and p.name ilike :name", nativeQuery = true)
    List<TrainingSession> findAllByTrainingProgramNameContainingIgnoreCase(String name);

    @Query(value = "select * from training_sessions s inner join training_programs p on s.program_id = p.id and p.id = :id", nativeQuery = true)
    List<TrainingSession> findAllByTrainingProgramId(UUID id);

    // FIND ONE
    TrainingSession findOneById(UUID id);

    TrainingSession findOneByNameIgnoreCaseAndUserId(String name, UUID id);
}
