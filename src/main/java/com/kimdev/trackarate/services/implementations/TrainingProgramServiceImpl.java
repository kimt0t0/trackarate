package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.TrainingProgramDto;
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

    @Override
    public UUID save(TrainingProgramDto dto) {
        validator.validate(dto);
        TrainingProgram program = TrainingProgramDto.toEntity(dto);
        return repository.save(program).getId();
    }

    @Override
    public List<TrainingProgramDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TrainingProgramDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TrainingProgramDto findById(UUID id) {
        return repository.findById(id)
                .map(TrainingProgramDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Training Program not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
