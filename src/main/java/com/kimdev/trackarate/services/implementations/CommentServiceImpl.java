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

    @Override
    public UUID save(CommentDto dto) {
        validator.validate(dto);
        Comment comment = CommentDto.toEntity(dto);
        return repository.save(comment).getId();
    }

    @Override
    public List<CommentDto> findAll() {
        return repository.findAll()
                .stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(UUID id) {
        return repository.findById(id)
                .map(CommentDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Comment was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
