package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.ExerciseDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;

public interface ExerciseService extends AbstractService<ExerciseDto> {

    // FIND MANY
    List<ExerciseDto> findAllByUserId(UUID id);

    List<ExerciseDto> findAllPublicByUserId(UUID id);

    List<ExerciseDto> findAllByUserUsername(String username);

    List<ExerciseDto> findAllPublicByUserUsername(String username);

    List<ExerciseDto> findAllByUserIdAndTitle(UUID id, String title);

    List<ExerciseDto> findAllPublicByUserIdAndTitle(UUID id, String title);

    List<ExerciseDto> findAllByTitle(String title);

    List<ExerciseDto> findAllPublicByTitle(String title);

    List<ExerciseDto> findAllBySearchInTitleAndDescription(String search);

    List<ExerciseDto> findAllPublicBySearchInTitleAndDescription(String search);

    List<ExerciseDto> findAllByExerciseTypesName(String name);

    List<ExerciseDto> findAllPublicByExerciseTypesName(String name);

    List<ExerciseDto> findAllByTrainingSessionsId(UUID sessionId);

    List<ExerciseDto> findAllPublicByTrainingSessionsId(UUID sessionId);

    List<ExerciseDto> findAllByTrainingSessionsName(String name);

    List<ExerciseDto> findAllPublicByTrainingSessionsName(String name);

    List<ExerciseDto> findAllPublicByTrainingSessionsNameAndState(String name,
            TrainingState state);

    List<ExerciseDto> findAllByState(TrainingState state);

    List<ExerciseDto> findAllPublicByState(TrainingState state);

    List<ExerciseDto> findAllByStateAndUserId(TrainingState state, UUID id);

    List<ExerciseDto> findAllPublicByStateAndUserId(TrainingState state, UUID id);

    List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndUserId(String name,
            TrainingState state, UUID id);

    List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndUserId(
            String name,
            TrainingState state, UUID id);

    List<ExerciseDto> findAllByFeeling(TrainingFeeling feeling);

    List<ExerciseDto> findAllPublicByFeeling(TrainingFeeling feeling);

    List<ExerciseDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllByTrainingSessionsNameAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllPublicByTrainingSessionsNameAndFeelingAndUserId(
            String name,
            TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<ExerciseDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling);

    List<ExerciseDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state,
            TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling);

    List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndFeelingAndUserId(
            String name,
            TrainingState state, TrainingFeeling feeling, UUID id);

    // FIND ONE
    ExerciseDto findOnePublicById(UUID id);

    ExerciseDto findOneByTitleAndUserId(String title, UUID id);

    ExerciseDto findOneByMediaListExerciseId(UUID id);

}
