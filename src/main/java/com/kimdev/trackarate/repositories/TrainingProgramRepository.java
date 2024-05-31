package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, UUID> {
    // FIND MANY
    List<TrainingProgram> findAll();

    List<TrainingProgram> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<TrainingProgram> findAllByUserId(UUID id);

    List<TrainingProgram> findAllByUserUsernameContainingIgnoreCase(String username);

    // second parameter is the type's name
    List<TrainingProgram> findAllByUserSettingsIsPrivateAndProgramTypesNameContainingIgnoreCase(boolean isPrivate,
            String name);

    @Query(value = "select * from training_programs p inner join training_sessions s on p.session_id = s.id and s.name ilike :name", nativeQuery = true)
    List<TrainingProgram> findAllByTrainingSessionNameContainingIgnoreCase(String name);

    @Query(value = "select * from training_programs p inner join training_sessions s on p.session_id = s.id and s.id = :id", nativeQuery = true)
    List<TrainingProgram> findAllByTrainingSessionId(UUID id);

    // FIND ONE
    TrainingProgram findOneById(UUID id);

    TrainingProgram findOneByNameIgnoreCaseAndUserId(String name, UUID id);
}
