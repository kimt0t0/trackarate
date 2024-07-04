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

    // SAVE
    @Override
    public UUID save(AnswerDto dto) {
        validator.validate(dto);
        Answer answer = AnswerDto.toEntity(dto);
        return repository.save(answer).getId();
    }

    // FIND MANY
    @Override
    public List<AnswerDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllPublic() {
        return repository.findAllByUserSettingsIsPrivate(false)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllByUserUsername(String username) {
        return repository.findAllByUserUsernameContainingIgnoreCase(username)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllPublicByUserUsername(String username) {
        return repository.findAllByUserUsernameContainingIgnoreCaseAndUserSettingsIsPrivate(username, false)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllByUserId(UUID id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllPublicByUserId(UUID id) {
        return repository.findAllByUserIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllByQuestionId(UUID id) {
        return repository.findAllByQuestionId(id)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDto> findAllPublicByQuestionId(UUID id) {
        return repository.findAllByQuestionIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(AnswerDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public AnswerDto findById(UUID id) {
        return repository.findById(id)
                .map(AnswerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Answer was not found with provided id: " + id));
    }

    @Override
    public AnswerDto findOneByTextSearch(String search) {
        return repository.findOneByTextSearch(search)
                .map(AnswerDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Answer was not found with provided text search: " + search));
    }

    @Override
    public AnswerDto findOnePublicByTextSearch(String search) {
        return repository.findOneByTextSearchAndUserSettingsIsPrivate(search, false)
                .map(AnswerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Answer was not found with provided text search: "
                        + search + " or author's account is private"));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
