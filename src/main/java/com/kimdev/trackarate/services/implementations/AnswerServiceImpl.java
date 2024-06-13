package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.AnswerDto;
import com.kimdev.trackarate.models.Answer;
import com.kimdev.trackarate.repositories.AnswerRepository;
import com.kimdev.trackarate.services.AnswerService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;
    private final ObjectsValidator<AnswerDto> validator;

    @Override
    public UUID save(AnswerDto dto) {
        validator.validate(dto);
        Answer answer = AnswerDto.toEntity(dto);
        return repository.save(answer).getId();
    }

    @Override
    public List<AnswerDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto findById(UUID id) {
        return repository.findById(id)
                .map(AnswerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Answer was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
