package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.SettingsDto;
import com.kimdev.trackarate.models.Settings;
import com.kimdev.trackarate.repositories.SettingsRepository;
import com.kimdev.trackarate.services.SettingsService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository repository;
    private final ObjectsValidator<SettingsDto> validator;

    @Override
    public UUID initializeUserSettings(UUID userId) {
        Settings settings = SettingsDto.toEntity(
                new SettingsDto(
                        false,
                        true,
                        null,
                        true,
                        null,
                        null,
                        null,
                        userId));
        return repository.save(settings).getId();
    }

    @Override
    public UUID save(SettingsDto dto) {
        validator.validate(dto);
        Settings settings = SettingsDto.toEntity(dto);
        return repository.save(settings).getId();
    }

    @Override
    public List<SettingsDto> findAll() {
        return repository.findAll()
                .stream()
                .map(SettingsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SettingsDto findById(UUID id) {
        return repository.findById(id)
                .map(SettingsDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Settings not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public SettingsDto findOneByUserId(UUID userId) {
        return repository.findByUserId(userId)
                .map(SettingsDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Settings not found with provided user id: " + userId));
    }

}
