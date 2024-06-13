package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.TypeDto;
import com.kimdev.trackarate.models.Type;
import com.kimdev.trackarate.repositories.TypeRepository;
import com.kimdev.trackarate.services.TypeService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;
    private final ObjectsValidator<TypeDto> validator;

    @Override
    public UUID save(TypeDto dto) {
        validator.validate(dto);
        Type type = TypeDto.toEntity(dto);
        return repository.save(type).getId();
    }

    @Override
    public List<TypeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TypeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDto findById(UUID id) {
        return repository.findById(id)
                .map(TypeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Type not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
