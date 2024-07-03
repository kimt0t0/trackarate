package com.kimdev.trackarate.repositories;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, UUID> {
    // FIND MANY
    List<TrainingProgram> findAll();

    List<TrainingProgram> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<TrainingProgram> findAllByUserId(UUID id);

    List<TrainingProgram> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByEndDateBefore(Date endDate); // finished programs

    List<TrainingProgram> findAllByEndDateBeforeAndUserSettingsIsPrivate(Date endDate, boolean isPrivate);

    List<TrainingProgram> findAllByStartDateAfter(Date startDate); // not started yet programs

    List<TrainingProgram> findAllByStartDateAfterAndUserSettingsIsPrivate(Date startDate, boolean isPrivate);

    List<TrainingProgram> findAllByStartDateAfterAndEndDateBefore(Date startDate, Date enDate); // started but not
                                                                                                // finished programs

    List<TrainingProgram> findAllByStartDateAfterAndEndDateBeforeAndUserSettingsIsPrivate(Date startDate, Date enDate,
            boolean isPrivate);

    List<TrainingProgram> findAllByUserIdAndEndDateBefore(UUID id, Date endDate); // finished programs

    List<TrainingProgram> findAllByUserIdAndEndDateBeforeAndUserSettingsIsPrivate(UUID id, Date endDate,
            boolean isPrivate);

    List<TrainingProgram> findAllByUserIdAndStartDateAfter(UUID id, Date startDate); // not started yet programs

    List<TrainingProgram> findAllByUserIdAndStartDateAfterAndUserSettingsIsPrivate(UUID id, Date startDate,
            boolean isPrivate);

    List<TrainingProgram> findAllByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate, Date enDate); // started
                                                                                                                  // but
                                                                                                                  // not
                                                                                                                  // finished
                                                                                                                  // programs

    List<TrainingProgram> findAllByUserIdAndStartDateAfterAndEndDateBeforeAndUserSettingsIsPrivate(UUID id,
            Date startDate, Date enDate, boolean isPrivate);

    List<TrainingProgram> findAllByUserUsernameContainingIgnoreCase(String username);

    List<TrainingProgram> findAllByUserUsernameContainingIgnoreCaseAndUserSettingsIsPrivate(String username,
            boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCase(String name);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<TrainingProgram> findAllByTrainingSessionsId(UUID id);

    List<TrainingProgram> findAllByTrainingSessionsIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByTrainingSessionsNameContainingIgnoreCase(String name);

    List<TrainingProgram> findAllByTrainingSessionsNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name,
            boolean isPrivate);

    List<TrainingProgram> findAllByState(TrainingState state);

    List<TrainingProgram> findAllByStateAndUserSettingsIsPrivate(TrainingState state, boolean isPrivate);

    List<TrainingProgram> findAllByStateAndUserId(TrainingState state, UUID id);

    List<TrainingProgram> findAllByStateAndUserIdAndUserSettingsIsPrivate(TrainingState state, UUID id,
            boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndState(String name,
            TrainingState state);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(String name,
            TrainingState state, boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingState state, UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByFeeling(TrainingFeeling feeling);

    List<TrainingProgram> findAllByFeelingAndUserSettingsIsPrivate(TrainingFeeling feeling, boolean isPrivate);

    List<TrainingProgram> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByFeelingAndUserIdAndUserSettingsIsPrivate(TrainingFeeling feeling, UUID id,
            boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeeling(
            String name,
            TrainingFeeling feeling);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingProgram> findAllByStateAndFeelingAndUserSettingsIsPrivate(TrainingState state, TrainingFeeling feeling,
            boolean isPrivate);

    List<TrainingProgram> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(TrainingState state,
            TrainingFeeling feeling, UUID id, boolean isPrivate);

    List<TrainingProgram> findAllByNameContainingIgnoreCase(String name);

    List<TrainingProgram> findAllByNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name, boolean isPrivate);

    List<TrainingProgram> findAllByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    List<TrainingProgram> findAllByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(String name, UUID id,
            boolean isPrivate);

    // COUNT
    @Query(value = "select state, count(*) from training_programs", nativeQuery = true)
    Map<TrainingState, Integer> findCountProgramsByState();

    @Query(value = "select state, count(*) from training_programs p inner join users u on p.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountProgramsByUserAndState(UUID userId);

    @Query(value = "select feeling, count(*) from training_programs", nativeQuery = true)
    Map<TrainingState, Integer> findCountProgramsByFeeling();

    @Query(value = "select feeling, count(*) from training_programs p inner join users u on p.user_id = u.id where u.id = :userId", nativeQuery = true)
    Map<TrainingState, Integer> findCountProgramsByUserAndFeeling(UUID userId);

    // FIND ONE
    Optional<TrainingProgram> findOneById(UUID id);

    Optional<TrainingProgram> findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Optional<TrainingProgram> findOneByNameContainingIgnoreCase(String name);

    Optional<TrainingProgram> findOneByNameContainingIgnoreCaseAndUserSettingsIsPrivate(String name, boolean isPrivate);

    Optional<TrainingProgram> findOneByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    Optional<TrainingProgram> findOneByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(String name, UUID id,
            boolean isPrivate);
}
