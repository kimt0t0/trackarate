package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.MediaDto;
import com.kimdev.trackarate.enums.MediaType;
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

    // SAVE
    @Override
    public UUID save(MediaDto dto) {
        validator.validate(dto);
        Media media = MediaDto.toEntity(dto);
        return repository.save(media).getId();
    }

    // FIND MANY
    @Override
    public List<MediaDto> findAll() {
        return repository.findAll()
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublic() {
        return repository.findAllByUserSettingsIsPrivate(false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByExerciseId(UUID id) {
        return repository.findAllByExerciseId(id)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByExerciseId(UUID id) {
        return repository.findAllByExerciseIdAndUserSettingsIsPrivate(id, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByExerciseTitle(String title) {
        return repository.findAllByExerciseTitleContainingIgnoreCase(title)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByExerciseTitle(String title) {
        return repository.findAllByExerciseTitleContainingIgnoreCaseAndUserSettingsIsPrivate(title, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByTitle(String title) {
        return repository.findAllByTitleContainingIgnoreCase(title)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByTitle(String title) {
        return repository.findAllByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(title, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByTitleAndType(String title, MediaType type) {
        return repository.findAllByTitleContainingIgnoreCaseAndType(title, type)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByTitleAndType(String title, MediaType type) {
        return repository.findAllByTitleContainingIgnoreCaseAndTypeAndUserSettingsIsPrivate(title, type, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByTitleOrDescription(String search) {
        return repository.findAllByTitleOrDescription(search)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByTitleOrDescription(String search) {
        return repository.findAllByTitleOrDescriptionAndUserSettingsIsPrivate(search, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllByTitleOrDescriptionAndType(String search, MediaType type) {
        return repository.findAllByTitleOrDescriptionAndType(search, type)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaDto> findAllPublicByTitleOrDescriptionAndType(String search, MediaType type) {
        return repository.findAllByTitleOrDescriptionAndTypeAndUserSettingsIsPrivate(search, type, false)
                .stream()
                .map(MediaDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public MediaDto findById(UUID id) {
        return repository.findById(id)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Media was not found with provided id: " + id));
    }

    @Override
    public MediaDto findOnePublic(UUID id) {
        return repository.findOneByIdAndUserSettingsIsPrivate(id, false)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Media was not found with provided id: " + id + "or user account is private"));
    }

    @Override
    public MediaDto findOneByTitle(String title) {
        return repository.findOneByTitleContainingIgnoreCase(title)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Media was not found with provided title: " + title));
    }

    @Override
    public MediaDto findOnePublicByTitle(String title) {
        return repository.findOneByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(title, false)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Media was not found with provided title: " + title + "or user account is private"));
    }

    @Override
    public MediaDto findOneByTitleAndUserUsername(String title, String username) {
        return repository.findOneByTitleContainingIgnoreCaseAndUserUsername(title, username)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Media was not found with provided title: " + title + " and username: " + username));
    }

    @Override
    public MediaDto findOnePublicByTitleAndUserUsername(String title, String username) {
        return repository
                .findOneByTitleContainingIgnoreCaseAndUserUsernameAndUserSettingsIsPrivate(title, username, false)
                .map(MediaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Media was not found with provided title: " + title + " and username: " + username
                                + "or user account is private"));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
