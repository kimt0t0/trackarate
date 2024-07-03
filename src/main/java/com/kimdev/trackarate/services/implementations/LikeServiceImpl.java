package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.LikeDto;
import com.kimdev.trackarate.models.Like;
import com.kimdev.trackarate.repositories.LikeRepository;
import com.kimdev.trackarate.services.LikeService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;
    private final ObjectsValidator<LikeDto> validator;

    // SAVE
    @Override
    public UUID save(LikeDto dto) {
        validator.validate(dto);
        Like like = LikeDto.toEntity(dto);
        return repository.save(like).getId();
    }

    // FIND MANY
    @Override
    public List<LikeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByUserId(UUID id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllPublicByUserId(UUID id) {
        return repository.findAllByUserIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByUserUsername(String id) {
        return repository.findAllByUserUsername(id)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllPublicByUserUsername(String id) {
        return repository.findAllByUserUsernameAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByExerciseId(UUID id) {
        return repository.findAllByExerciseId(id)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllPublicByExerciseId(UUID id) {
        return repository.findAllByExerciseIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByTrainingProgramId(UUID id) {
        return repository.findAllByTrainingProgramId(id)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllPublicByTrainingProgramId(UUID id) {
        return repository.findAllByTrainingProgramIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByTrainingSessionId(UUID id) {
        return repository.findAllByTrainingSessionId(id)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllPublicByTrainingSessionId(UUID id) {
        return repository.findAllByTrainingSessionIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public LikeDto findById(UUID id) {
        return repository.findById(id)
                .map(LikeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Like was not found with provided id: " + id));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
