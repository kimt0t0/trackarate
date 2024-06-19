package com.kimdev.trackarate.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, UUID> {
    // FIND MANY
    List<TrainingProgram> findAll();

    List<TrainingProgram> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<TrainingProgram> findAllByUserId(UUID id);

    List<TrainingProgram> findAllByEndDateBefore(Date endDate); // finished programs

    List<TrainingProgram> findAllByStartDateAfter(Date startDate); // not started yet programs

    List<TrainingProgram> findAllByStartDateAfterAndEndDateBefore(Date startDate, Date enDate); // started but not
                                                                                                // finished programs

    List<TrainingProgram> findAllByUserIdAndEndDateBefore(UUID id, Date endDate); // finished programs

    List<TrainingProgram> findAllByUserIdAndStartDateAfter(UUID id, Date startDate); // not started yet programs

    List<TrainingProgram> findAllByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate, Date enDate); // started
                                                                                                                  // but
                                                                                                                  // not
                                                                                                                  // finished
                                                                                                                  // programs

    List<TrainingProgram> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

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

    List<TrainingProgram> findAllByStateAndUserSettingsIsPrivate(TrainingState state, boolean isPrivate);

    List<TrainingProgram> findAllByStateAndUserId(TrainingState state, UUID id);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(String name,
            TrainingState state, boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingProgram> findAllByFeelingAndUserSettingsIsPrivate(TrainingFeeling feeling, boolean isPrivate);

    List<TrainingProgram> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingFeeling feeling, boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByStateAndFeelingAndUserSettingsIsPrivate(TrainingState state, TrainingFeeling feeling,
            boolean isPrivate);

    List<TrainingProgram> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(
            String name,
            TrainingState state, TrainingFeeling feeling, boolean isPrivate);

    List<TrainingProgram> findAllByProgramTypesNameContainingIgnoreCaseAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    // FIND ONE
    TrainingProgram findOneById(UUID id);

    TrainingProgram findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    TrainingProgram findOneByNameContainingIgnoreCaseAndUserId(String name, UUID id);

    TrainingProgram findOneByCommentsId(UUID commentId);

    TrainingProgram findOneByLikesId(UUID likeId);

    TrainingProgram findOneByCommentsIdAndUserSettingsIsPrivate(UUID commentId, boolean isPrivate);

    TrainingProgram findOneByLikesIdAndUserSettingsIsPrivate(UUID likeId, boolean isPrivate);
}
