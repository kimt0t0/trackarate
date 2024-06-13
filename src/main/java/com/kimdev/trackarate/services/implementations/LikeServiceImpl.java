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

    @Override
    public UUID save(LikeDto dto) {
        validator.validate(dto);
        Like like = LikeDto.toEntity(dto);
        return repository.save(like).getId();
    }

    @Override
    public List<LikeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(LikeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public LikeDto findById(UUID id) {
        return repository.findById(id)
                .map(LikeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Like was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
