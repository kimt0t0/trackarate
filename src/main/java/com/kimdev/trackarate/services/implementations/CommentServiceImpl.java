package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.CommentDto;
import com.kimdev.trackarate.models.Comment;
import com.kimdev.trackarate.repositories.CommentRepository;
import com.kimdev.trackarate.services.CommentService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final ObjectsValidator<CommentDto> validator;

    // SAVE
    @Override
    public UUID save(CommentDto dto) {
        validator.validate(dto);
        Comment comment = CommentDto.toEntity(dto);
        return repository.save(comment).getId();
    }

    // FIND MANY
    @Override
    public List<CommentDto> findAll() {
        return repository.findAll()
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllByUserId(UUID id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllPublicByUserId(UUID id) {
        return repository.findAllByUserIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllByUserUsername(String id) {
        return repository.findAllByUserUsername(id)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllPublicByUserUsername(String id) {
        return repository.findAllByUserUsernameAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllByExerciseId(UUID id) {
        return repository.findAllByExerciseId(id)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllPublicByExerciseId(UUID id) {
        return repository.findAllByExerciseIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllByTrainingProgramId(UUID id) {
        return repository.findAllByTrainingProgramId(id)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllPublicByTrainingProgramId(UUID id) {
        return repository.findAllByTrainingProgramIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllByTrainingSessionId(UUID id) {
        return repository.findAllByTrainingSessionId(id)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> findAllPublicByTrainingSessionId(UUID id) {
        return repository.findAllByTrainingSessionIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public CommentDto findById(UUID id) {
        return repository.findById(id)
                .map(CommentDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Comment was not found with provided id: " + id));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
