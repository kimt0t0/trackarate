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

    // SAVE
    @Override
    public UUID save(AvatarDto dto) {
        validator.validate(dto);
        Avatar avatar = AvatarDto.toEntity(dto);
        return repository.save(avatar).getId();
    }

    // FIND MANY
    @Override
    public List<AvatarDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AvatarDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AvatarDto> findAllPublic() {
        return repository.findAllByUserSettingsIsPrivate(false)
                .stream()
                .map(AvatarDto::fromEntity)
                .collect(Collectors.toList());
    }

    // FIND ONE
    @Override
    public AvatarDto findById(UUID id) {
        return repository.findById(id)
                .map(AvatarDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Avatar was not found with provided id: " + id));
    }

    @Override
    public AvatarDto findOnePublic(UUID id) {
        return repository.findOneByIdAndUserSettingsIsPrivate(id, false)
                .map(AvatarDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Avatar was not found with provided id: " + id + " or owner's account is private"));
    }

    @Override
    public AvatarDto findOneByUserId(UUID id) {
        return repository.findOneByUserId(id)
                .map(AvatarDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Avatar was not found with provided user id: " + id));
    }

    @Override
    public AvatarDto findOnePublicByUserId(UUID id) {
        return repository.findOneByUserIdAndUserSettingsIsPrivate(id, false)
                .map(AvatarDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Avatar was not found with provided user id: " + id
                        + " or owner's account is private"));
    }

    @Override
    public AvatarDto findOneByUserUsername(String username) {
        return repository.findOneByUserUsername(username)
                .map(AvatarDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Avatar was not found with provided username: " + username));
    }

    @Override
    public AvatarDto findOnePublicByUserUsername(String username) {
        return repository.findOneByUserUsernameAndUserSettingsIsPrivate(username, false)
                .map(AvatarDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Avatar was not found with provided username: " + username
                                + " or owner's account is private"));
    }

    // DELETE
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
