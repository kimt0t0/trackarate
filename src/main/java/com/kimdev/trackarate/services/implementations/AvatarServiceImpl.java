package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.AvatarDto;
import com.kimdev.trackarate.models.Avatar;
import com.kimdev.trackarate.repositories.AvatarRepository;
import com.kimdev.trackarate.services.AvatarService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private final AvatarRepository repository;
    private final ObjectsValidator<AvatarDto> validator;

    @Override
    public UUID save(AvatarDto dto) {
        validator.validate(dto);
        Avatar avatar = AvatarDto.toEntity(dto);
        return repository.save(avatar).getId();
    }

    @Override
    public List<AvatarDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AvatarDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AvatarDto findById(UUID id) {
        return repository.findById(id)
                .map(AvatarDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Avatar was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
