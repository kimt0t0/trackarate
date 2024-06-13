package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.ExerciseDto;
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

    @Override
    public UUID save(ExerciseDto dto) {
        validator.validate(dto);
        Exercise exercise = ExerciseDto.toEntity(dto);
        return repository.save(exercise).getId();
    }

    @Override
    public List<ExerciseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ExerciseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseDto findById(UUID id) {
        return repository.findById(id)
                .map(ExerciseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Exercise was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
