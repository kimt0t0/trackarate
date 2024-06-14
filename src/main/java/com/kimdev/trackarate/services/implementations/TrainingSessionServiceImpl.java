package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.TrainingSessionDto;
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

    @Override
    public UUID save(TrainingSessionDto dto) {
        validator.validate(dto);
        TrainingSession session = TrainingSessionDto.toEntity(dto);
        return repository.save(session).getId();
    }

    @Override
    public List<TrainingSessionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TrainingSessionDto findById(UUID id) {
        return repository.findById(id)
                .map(TrainingSessionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Training Session not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<TrainingSessionDto> findAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(TrainingSessionDto::fromEntity)
                .collect(Collectors.toList());
    }

}
