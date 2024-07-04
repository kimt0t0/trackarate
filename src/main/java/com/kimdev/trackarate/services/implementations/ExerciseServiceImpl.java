package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.ExerciseDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.Exercise;
import com.kimdev.trackarate.repositories.ExerciseRepository;
import com.kimdev.trackarate.services.ExerciseService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository repository;
    private final ObjectsValidator<ExerciseDto> validator;

    // SAVE
    @Override
    public UUID save(ExerciseDto dto) {
        validator.validate(dto);
        Exercise exercise = ExerciseDto.toEntity(dto);
        return repository.save(exercise).getId();
    }

    // FIND MANY
    @Override
    public List<ExerciseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByUserId(UUID id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByUserId(UUID id) {
        return repository.findAllByUserIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByUserUsername(String username) {
        return repository.findAllByUserUsername(username)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByUserUsername(String username) {
        return repository.findAllByUserUsernameAndUserSettingsIsPrivate(username, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByUserIdAndTitle(UUID id, String title) {
        return repository.findAllByUserIdAndTitleContainingIgnoreCase(id, title)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByUserIdAndTitle(UUID id, String title) {
        return repository.findAllByUserIdAndTitleContainingIgnoreCaseAndUserSettingsIsPrivate(id, title, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTitle(String title) {
        return repository.findAllByTitleContainingIgnoreCase(title)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTitle(String title) {
        return repository.findAllByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(title, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllBySearchInTitleAndDescription(String search) {
        return repository.findAllBySearchInTitleAndDescription(search)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicBySearchInTitleAndDescription(String search) {
        return repository.findAllBySearchInTitleAndDescriptionAndUserSettingsIsPrivate(search, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByExerciseTypesName(String name) {
        return repository.findAllByExerciseTypesNameContainingIgnoreCase(name)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByExerciseTypesName(String name) {
        return repository.findAllByExerciseTypesNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsId(UUID sessionId) {
        return repository.findAllByTrainingSessionsId(sessionId)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsId(UUID sessionId) {
        return repository.findAllByTrainingSessionsIdAndUserSettingsIsPrivate(sessionId, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsName(String name) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCase(name)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsName(String name) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsNameAndState(String name,
            TrainingState state) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(name, state, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByState(TrainingState state) {
        return repository.findAllByState(state)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByState(TrainingState state) {
        return repository.findAllByStateAndUserSettingsIsPrivate(state, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserId(state, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserIdAndUserSettingsIsPrivate(state, id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserId(name, state, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(name, state,
                        id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeeling(feeling)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeelingAndUserSettingsIsPrivate(feeling, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserId(feeling, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserIdAndUserSettingsIsPrivate(feeling, id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsNameAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserId(name, feeling, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsNameAndFeelingAndUserId(String name,
            TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(name,
                        feeling, id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeeling(state, feeling)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeelingAndUserSettingsIsPrivate(state, feeling, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling, UUID id) {
        return repository.findAllByStateAndFeelingAndUserId(state, feeling, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(state, feeling, id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeeling(name, state, feeling)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(name,
                        state, feeling, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllByTrainingSessionsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserId(name, state, feeling, id)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> findAllPublicByTrainingSessionsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingSessionsNameContainingIgnoreCaseAndStateAndFeelingAndUserIdAndUserSettingsIsPrivate(
                        name, state, feeling, id, false)
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public ExerciseDto findById(UUID id) {
        return repository.findById(id)
                .map(ExerciseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Exercise was not found with provided id: " + id));
    }

    @Override
    public ExerciseDto findOnePublicById(UUID id) {
        return repository.findOneByIdAndUserSettingsIsPrivate(id, false)
                .map(ExerciseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Exercise was not found with provided id: " + id + " or the owner's account is private"));
    }

    @Override
    public ExerciseDto findOneByTitleAndUserId(String title, UUID id) {
        return repository.findOneByTitleContainingIgnoreCaseAndUserId(title, id)
                .map(ExerciseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Exercise was not found with provided title: " + title + " and user id: " + id));
    }

    @Override
    public ExerciseDto findOneByMediaListExerciseId(UUID id) {
        return repository.findOneByMediaListExerciseId(id)
                .map(ExerciseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Exercise was not found with provided media id: " + id));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
