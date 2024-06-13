package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.QuestionDto;
import com.kimdev.trackarate.models.Question;
import com.kimdev.trackarate.repositories.QuestionRepository;
import com.kimdev.trackarate.services.QuestionService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final ObjectsValidator<QuestionDto> validator;

    @Override
    public UUID save(QuestionDto dto) {
        validator.validate(dto);
        Question question = QuestionDto.toEntity(dto);
        return repository.save(question).getId();
    }

    @Override
    public List<QuestionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(QuestionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto findById(UUID id) {
        return repository.findById(id)
                .map(QuestionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
