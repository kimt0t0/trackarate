package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.MediaDto;
import com.kimdev.trackarate.models.Media;
import com.kimdev.trackarate.repositories.MediaRepository;
import com.kimdev.trackarate.services.MediaService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository repository;
    private final ObjectsValidator<MediaDto> validator;

    @Override
    public UUID save(MediaDto dto) {
        validator.validate(dto);
        Media media = MediaDto.toEntity(dto);
        return repository.save(media).getId();
    }

    @Override
    public List<MediaDto> findAll() {
        return repository.findAll()
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MediaDto findById(UUID id) {
        return repository.findById(id)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Media was not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
