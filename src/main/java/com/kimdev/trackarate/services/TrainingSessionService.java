package com.kimdev.trackarate.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.TrainingSessionDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

public interface TrainingSessionService extends AbstractService<TrainingSessionDto> {

    List<TrainingSessionDto> findAllByUserUsername(String username);

    List<TrainingSessionDto> findAllBySessionTypesId(UUID id);

    List<TrainingSessionDto> findAllByDatetime(ZonedDateTime datetime);

    List<TrainingSessionDto> findAllByDatetimeAndUserId(ZonedDateTime datetime, UUID id);

    List<TrainingSessionDto> findAllPublicByDatetimeAndUserId(ZonedDateTime datetime, UUID id);

    List<TrainingSessionDto> findAllByDatetimeBefore(ZonedDateTime datetime);

    List<TrainingSessionDto> findAllByDatetimeAfter(ZonedDateTime datetime);

    List<TrainingSessionDto> findAllBySessionTypesName(String name);

    List<TrainingSessionDto> findAllPublicBySessionTypesId(UUID id);

    List<TrainingSessionDto> findAllPublicBySessionTypesName(String name);

    List<TrainingSessionDto> findAllByUserId(UUID id);

    List<TrainingSessionDto> findAllByNameAndUserId(String name, UUID id);

    List<TrainingSessionDto> findAllPublicByNameAndUserId(String name, UUID id);

    List<TrainingSessionDto> findAllByTrainingProgramsName(String name);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsName(String name);

    List<TrainingSessionDto> findAllByTrainingProgramsId(UUID id);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsId(UUID id);

    List<TrainingSessionDto> findAllByExercisesId(UUID id);

    List<TrainingSessionDto> findAllPublicByExercisesId(UUID id);

    List<TrainingSessionDto> findAllByExercisesTitle(String title);

    List<TrainingSessionDto> findAllPublicByExercisesTitle(String title);

    List<TrainingSessionDto> findAllByState(TrainingState state);

    List<TrainingSessionDto> findAllPublicByState(TrainingState state);

    List<TrainingSessionDto> findAllByStateAndUserId(TrainingState state, UUID id);

    List<TrainingSessionDto> findAllPublicByStateAndUserId(TrainingState state, UUID id);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndState(String name,
            TrainingState state);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndState(String name,
            TrainingState state);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<TrainingSessionDto> findAllByFeeling(TrainingFeeling feeling);

    List<TrainingSessionDto> findAllPublicByFeeling(TrainingFeeling feeling);

    List<TrainingSessionDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndFeeling(String name,
            TrainingFeeling feeling);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndFeeling(String name,
            TrainingFeeling feeling);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndFeelingAndUserId(
            String name,
            TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingSessionDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<TrainingSessionDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling,
            UUID id);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    TrainingSessionDto findOnePublicById(UUID id);

    TrainingSessionDto findOneByNameAndUserId(String name, UUID id);

    TrainingSessionDto findOnePublicByNameAndUserId(String name, UUID id);

}
