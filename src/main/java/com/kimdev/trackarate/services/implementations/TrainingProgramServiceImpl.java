package com.kimdev.trackarate.services.implementations;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.TrainingProgramDto;
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
import com.kimdev.trackarate.models.TrainingProgram;
import com.kimdev.trackarate.repositories.TrainingProgramRepository;
import com.kimdev.trackarate.services.TrainingProgramService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepository repository;
    private final ObjectsValidator<TrainingProgramDto> validator;

    // SAVE
    @Override
    public UUID save(TrainingProgramDto dto) {
        validator.validate(dto);
        TrainingProgram program = TrainingProgramDto.toEntity(dto);
        return repository.save(program).getId();
    }

    // FIND MANY
    @Override
    public List<TrainingProgramDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublic() {
        return repository.findAllByUserSettingsIsPrivate(false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByUserId(UUID id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByUserId(UUID id) {
        return repository.findAllByUserIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByEndDateBefore(Date endDate) {
        return repository.findAllByEndDateBefore(endDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByEndDateBefore(Date endDate) {
        return repository.findAllByEndDateBeforeAndUserSettingsIsPrivate(endDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByStartDateAfter(Date startDate) {
        return repository.findAllByStartDateAfter(startDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByStartDateAfter(Date startDate) {
        return repository.findAllByStartDateAfterAndUserSettingsIsPrivate(startDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByStartDateAfterAndEndDateBefore(Date startDate, Date endDate) {
        return repository.findAllByStartDateAfterAndEndDateBefore(startDate, endDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByStartDateAfterAndEndDateBefore(Date startDate, Date endDate) {
        return repository.findAllByStartDateAfterAndEndDateBeforeAndUserSettingsIsPrivate(startDate, endDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByUserIdAndEndDateBefore(UUID id, Date endDate) {
        return repository.findAllByUserIdAndEndDateBefore(id, endDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByUserIdAndEndDateBefore(UUID id, Date endDate) {
        return repository.findAllByUserIdAndEndDateBeforeAndUserSettingsIsPrivate(id, endDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByUserIdAndStartDateAfter(UUID id, Date startDate) {
        return repository.findAllByUserIdAndStartDateAfter(id, startDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByUserIdAndStartDateAfter(UUID id, Date startDate) {
        return repository.findAllByUserIdAndStartDateAfterAndUserSettingsIsPrivate(id, startDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate,
            Date enDate) {
        return repository.findAllByUserIdAndStartDateAfterAndEndDateBefore(id, startDate, enDate)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByUserIdAndStartDateAfterAndEndDateBefore(UUID id, Date startDate,
            Date enDate) {
        return repository
                .findAllByUserIdAndStartDateAfterAndEndDateBeforeAndUserSettingsIsPrivate(id, startDate, enDate, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByUserUsername(String username) {
        return repository.findAllByUserUsernameContainingIgnoreCase(username)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByUserUsername(String username) {
        return repository.findAllByUserUsernameContainingIgnoreCaseAndUserSettingsIsPrivate(username, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByProgramTypesName(String name) {
        return repository.findAllByProgramTypesNameContainingIgnoreCase(name)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByProgramTypesName(String name) {
        return repository.findAllByProgramTypesNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByTrainingSessionsId(UUID id) {
        return repository.findAllByTrainingSessionsId(id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByTrainingSessionsId(UUID id) {
        return repository.findAllByTrainingSessionsIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByTrainingSessionsName(String name) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCase(name)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByTrainingSessionsName(String name) {
        return repository.findAllByTrainingSessionsNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByState(TrainingState state) {
        return repository.findAllByState(state)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByState(TrainingState state) {
        return repository.findAllByStateAndUserSettingsIsPrivate(state, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserId(state, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByStateAndUserId(TrainingState state, UUID id) {
        return repository.findAllByStateAndUserIdAndUserSettingsIsPrivate(state, id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByProgramTypesNameAndState(String name, TrainingState state) {
        return repository.findAllByProgramTypesNameContainingIgnoreCaseAndState(name, state)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByProgramTypesNameAndState(String name, TrainingState state) {
        return repository
                .findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserSettingsIsPrivate(name, state, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByProgramTypesNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository.findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserId(name, state, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByProgramTypesNameAndStateAndUserId(String name,
            TrainingState state, UUID id) {
        return repository
                .findAllByProgramTypesNameContainingIgnoreCaseAndStateAndUserIdAndUserSettingsIsPrivate(name, state, id,
                        false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeeling(feeling)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByFeeling(TrainingFeeling feeling) {
        return repository.findAllByFeelingAndUserSettingsIsPrivate(feeling, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserId(feeling, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByFeelingAndUserId(TrainingFeeling feeling, UUID id) {
        return repository.findAllByFeelingAndUserIdAndUserSettingsIsPrivate(feeling, id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByProgramTypesNameAndFeeling(String name, TrainingFeeling feeling) {
        return repository.findAllByProgramTypesNameContainingIgnoreCaseAndFeeling(name, feeling)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByProgramTypesNameAndFeeling(String name, TrainingFeeling feeling) {
        return repository
                .findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserSettingsIsPrivate(name, feeling, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByProgramTypesNameAndFeelingAndUserId(String name, TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserId(name, feeling, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByProgramTypesNameAndFeelingAndUserId(String name,
            TrainingFeeling feeling,
            UUID id) {
        return repository
                .findAllByProgramTypesNameContainingIgnoreCaseAndFeelingAndUserIdAndUserSettingsIsPrivate(name, feeling,
                        id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeeling(state, feeling)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByStateAndFeeling(TrainingState state, TrainingFeeling feeling) {
        return repository.findAllByStateAndFeelingAndUserSettingsIsPrivate(state, feeling, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByStateAndFeelingAndUserId(TrainingState state, TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByStateAndFeelingAndUserId(state, feeling, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByStateAndFeelingAndUserId(TrainingState state,
            TrainingFeeling feeling,
            UUID id) {
        return repository.findAllByStateAndFeelingAndUserIdAndUserSettingsIsPrivate(state, feeling, id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByName(String name) {
        return repository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByName(String name) {
        return repository.findAllByNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllByNameAndUserId(String name, UUID id) {
        return repository.findAllByNameContainingIgnoreCaseAndUserId(name, id)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingProgramDto> findAllPublicByNameAndUserId(String name, UUID id) {
        return repository.findAllByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(name, id, false)
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public TrainingProgramDto findById(UUID id) {
        return repository.findById(id)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Training Program not found with provided id: " + id));
    }

    @Override
    public TrainingProgramDto findOnePublic(UUID id) {
        return repository.findOneByIdAndUserSettingsIsPrivate(id, false)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Training Program not found with provided id: " + id));
    }

    @Override
    public TrainingProgramDto findOneByName(String name) {
        return repository.findOneByNameContainingIgnoreCase(name)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Training Program not found with provided name: " + name));
    }

    @Override
    public TrainingProgramDto findOnePublicByName(String name) {
        return repository.findOneByNameContainingIgnoreCaseAndUserSettingsIsPrivate(name, false)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Training Program not found with provided name: " + name
                                + " or owner has a private account"));
    }

    @Override
    public TrainingProgramDto findOneByNameAndUserId(String name, UUID id) {
        return repository.findOneByNameContainingIgnoreCaseAndUserId(name, id)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Training Program not found with provided name: " + name
                                + " and user id: " + id));
    }

    @Override
    public TrainingProgramDto findOnePublicByNameAndUserId(String name, UUID id) {
        return repository.findOneByNameContainingIgnoreCaseAndUserIdAndUserSettingsIsPrivate(name, id, false)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Training Program not found with provided name: " + name
                                + " and user id: " + id + " or owner has a private account"));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
