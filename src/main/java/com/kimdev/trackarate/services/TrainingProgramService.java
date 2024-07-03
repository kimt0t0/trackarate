package com.kimdev.trackarate.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.TrainingProgramDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

public interface TrainingProgramService extends AbstractService<TrainingProgramDto> {

    // FIND MANY
    List<TrainingProgramDto> findAllPublic();

    List<TrainingProgramDto> findAllByUserId(UUID id);

    List<TrainingProgramDto> findAllPublicByUserId(UUID id);

    List<TrainingProgramDto> findAllByEndDateBefore(Date endDate);

    List<TrainingProgramDto> findAllPublicByEndDateBefore(Date endDate);

    List<TrainingProgramDto> findAllByStartDateAfter(Date startDate);

    List<TrainingProgramDto> findAllPublicByStartDateAfter(Date startDate);

    List<TrainingProgramDto> findAllByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);

    List<TrainingProgramDto> findAllPublicByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);

    List<TrainingProgramDto> findAllByUserIdAndEndDateBefore(UUID id, Date endDate);

    List<TrainingProgramDto> findAllPublicByUserIdAndEndDateBefore(UUID id, Date endDate);

    List<TrainingProgramDto> findAllByUserIdAndStartDateAfter(UUID id, Date startDate);

    List<TrainingProgramDto> findAllPublicByUserIdAndStartDateAfter(UUID id, Date startDate);

    // here
    List<TrainingProgramDto> findAllByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate, Date enDate);

    List<TrainingProgramDto> findAllPublicByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate,
            Date enDate);

    List<TrainingProgramDto> findAllByUserUsername(String username);

    List<TrainingProgramDto> findAllPublicByUserUsername(String username);

    List<TrainingProgramDto> findAllByProgramTypesName(String name);

    List<TrainingProgramDto> findAllPublicByProgramTypesName(String name);

    List<TrainingProgramDto> findAllByTrainingSessionsId(UUID id);

    List<TrainingProgramDto> findAllPublicByTrainingSessionsId(UUID id);

    List<TrainingProgramDto> findAllByTrainingSessionsName(String name);

    List<TrainingProgramDto> findAllPublicByTrainingSessionsName(String name);

    List<TrainingProgramDto> findAllByState(TrainingState state);

    List<TrainingProgramDto> findAllPublicByState(TrainingState state);

    List<TrainingProgramDto> findAllByStateAndUserId(TrainingState state, UUID id);

    List<TrainingProgramDto> findAllPublicByStateAndUserId(TrainingState state, UUID id);

    List<TrainingProgramDto> findAllByProgramTypesNameAndState(String name, TrainingState state);

    List<TrainingProgramDto> findAllPublicByProgramTypesNameAndState(String name, TrainingState state);

    List<TrainingProgramDto> findAllByProgramTypesNameAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingProgramDto> findAllPublicByProgramTypesNameAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingProgramDto> findAllByFeeling(TrainingFeeling feeling);

    List<TrainingProgramDto> findAllPublicByFeeling(TrainingFeeling feeling);

    List<TrainingProgramDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingProgramDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingProgramDto> findAllByProgramTypesNameAndFeeling(String name, TrainingFeeling feeling);

    List<TrainingProgramDto> findAllPublicByProgramTypesNameAndFeeling(String name, TrainingFeeling feeling);

    List<TrainingProgramDto> findAllByProgramTypesNameAndFeelingAndUserId(String name, TrainingFeeling feeling,
            UUID id);

    List<TrainingProgramDto> findAllPublicByProgramTypesNameAndFeelingAndUserId(String name, TrainingFeeling feeling,
            UUID id);

    List<TrainingProgramDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingProgramDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingProgramDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingProgramDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling,
            UUID id);

    List<TrainingProgramDto> findAllByName(String name);

    List<TrainingProgramDto> findAllPublicByName(String name);

    List<TrainingProgramDto> findAllByNameAndUserId(String name, UUID id);

    List<TrainingProgramDto> findAllPublicByNameAndUserId(String name, UUID id);

    // FIND ONE
    TrainingProgramDto findOnePublic(UUID id);

    TrainingProgramDto findOneByName(String name);

    TrainingProgramDto findOnePublicByName(String name);

    TrainingProgramDto findOneByNameAndUserId(String name, UUID id);

    TrainingProgramDto findOnePublicByNameAndUserId(String name, UUID id);

}
