package com.kimdev.trackarate.services.implementations;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.TrainingSessionDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingSession;
import com.kimdev.trackarate.repositories.TrainingSessionRepository;
import com.kimdev.trackarate.services.TrainingSessionService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private final TrainingSessionRepository repository;
    private final ObjectsValidator<TrainingSessionDto> validator;

    // SAVE
    @Override
    public UUID save(TrainingSessionDto dto) {
        validator.validate(dto);
        TrainingSession session = TrainingSessionDto.toEntity(dto);
        return repository.save(session).getId();
    }

    // GET MANY
    @Override
    public List<TrainingSessionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByUserUsername(String username) {
        return repository.findAllByUserUsername(username)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByDatetime(ZonedDateTime datetime) {
        return repository.findAllByDatetime(datetime)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByDatetimeAndUserId(ZonedDateTime datetime, UUID id) {
        return repository.findAllByDatetimeAndUserId(datetime, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByDatetimeAndUserId(ZonedDateTime datetime, UUID id) {
        return repository.findAllByDatetimeAndUserIdAndUserSettingsIsPrivate(datetime, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByDatetimeBefore(ZonedDateTime datetime) {
        return repository.findAllByDatetimeBefore(datetime)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByDatetimeAfter(ZonedDateTime datetime) {
        return repository.findAllByDatetimeAfter(datetime)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllBySessionTypesId(UUID id) {
        return repository.findAllBySessionTypesId(id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllBySessionTypesName(String name) {
        return repository.findAllBySessionTypesNameContainingIgnoreCase(name)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicBySessionTypesId(UUID id) {
        return repository.findAllByUserSettingsIsPrivateAndSessionTypesId(false, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicBySessionTypesName(String name) {
        return repository.findAllByUserSettingsIsPrivateAndSessionTypesNameContainingIgnoreCase(false, name)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByNameAndUserId(String name, UUID id) {
        return repository.findAllByNameContainingIgnoreCaseAndUserId(name, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByNameAndUserId(String name, UUID id) {
        return repository.findAllByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(name, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsName(String name) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCase(name)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsName(String name) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsId(UUID id) {
        return repository.findAllByTrainingProgramsId(id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsId(UUID id) {
        return repository.findAllByTrainingProgramsIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByExercisesId(UUID id) {
        return repository.findAllByExercisesId(id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByExercisesId(UUID id) {
        return repository.findAllByExercisesIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByExercisesTitle(String title) {
        return repository.findAllByExercisesTitleContainingIgnoreCase(title)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByExercisesTitle(String title) {
        return repository.findAllByExercisesTitleContainingIgnoreCaseAndUserSettingsIsPrivate(title, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByState(TrainingState state) {
        return repository.findAllByState(state)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByState(TrainingState state) {
        return repository.findAllByStateAndUserSettingsIsPrivate(state, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserId(state, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserIdAndUserSettingsIsPrivate(state, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndState(String name, TrainingState state) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(name, state, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndState(String name,
            TrainingState state) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndState(name, state)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserId(name, state, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(name, state,
                        id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeeling(feeling)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeelingAndUserSettingsIsPrivate(feeling, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserId(feeling, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserIdAndUserSettingsIsPrivate(feeling, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndFeeling(String name,
            TrainingFeeling feeling) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(name, feeling,
                        false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndFeeling(String name,
            TrainingFeeling feeling) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCaseAndFeeling(name, feeling)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndFeelingAndUserId(
            String name,
            TrainingFeeling feeling, UUID id) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserId(name, feeling, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndFeelingAndUserId(
            String name,
            TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(name,
                        feeling, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeeling(state, feeling)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeelingAndUserSettingsIsPrivate(state, feeling, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByStateAndFeelingAndUserId(state, feeling, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state,
            TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(state, feeling, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeeling(name, state, feeling)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndFeeling(
            String name,
            TrainingState state, TrainingFeeling feeling) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserSettingsIsPrivate(name,
                        state, feeling, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllByTrainingProgramsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserId(name, state, feeling, id)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingSessionDto> findAllPublicByTrainingProgramsNameAndStateAndFeelingAndUserId(String name,
            TrainingState state, TrainingFeeling feeling, UUID id) {
        return repository
                .findAllByTrainingProgramsNameContainingIgnoreCaseAndStateAndFeelingAndUserIdAndUserSettingsIsPrivate(
                        name, state, feeling, id, false)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    // GET ONE
    @Override
    public TrainingSessionDto findById(UUID id) {
        return repository.findOneById(id)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Training Session not found with provided id: " + id));
    }

    @Override
    public TrainingSessionDto findOnePublicById(UUID id) {
        return repository.findOneByIdAndUserSettingsIsPrivate(id, false)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Training Session not found with provided id: " + id + " or is not public"));
    }

    @Override
    public TrainingSessionDto findOneByNameAndUserId(String name, UUID id) {
        return repository.findOneByNameContainingIgnoreCaseAndUserId(name, id)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Training Session not found with provided name: " + name + " for user with id " + id));
    }

    @Override
    public TrainingSessionDto findOnePublicByNameAndUserId(String name, UUID id) {
        return repository.findOneByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(name, id, false)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Training Session not found with provided name: " + name + " for user with id " + id
                                + " or is not public"));
    }

    @Override
    public TrainingSessionDto findOneByCommentsId(UUID commentId) {
        return repository.findOneByCommentsId(commentId)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Training Session not found for comment with provided id: " + commentId));
    }

    @Override
    public TrainingSessionDto findOneByLikesId(UUID likeId) {
        return repository.findOneByLikesId(likeId)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Training Session not found for like with provided id: " + likeId));
    }

    @Override
    public TrainingSessionDto findOnePublicByCommentsId(UUID commentId) {
        return repository.findOneByCommentsIdAndUserSettingsIsPrivate(commentId, false)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Training Session not found for comment with provided id: " + commentId
                                        + " or is not public"));
    }

    @Override
    public TrainingSessionDto findOnePublicByLikesId(UUID likeId) {
        return repository.findOneByLikesIdAndUserSettingsIsPrivate(likeId, false)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Training Session not found for like with provided id: " + likeId
                                        + " or is not public"));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
