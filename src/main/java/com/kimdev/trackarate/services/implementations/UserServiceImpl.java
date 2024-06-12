package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.UserDto;
import com.kimdev.trackarate.models.User;
import com.kimdev.trackarate.repositories.UserRepository;
import com.kimdev.trackarate.services.UserService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ObjectsValidator<UserDto> validator;

    @Override
    public UUID save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(UUID id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with provided id : " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
