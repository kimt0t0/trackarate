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
    private final SettingsServiceImpl settingsService;

    @Override
    public UUID save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        User savedUser = repository.save(user);
        if (savedUser.getSettings() == null) {
            settingsService.initializeUserSettings(savedUser.getId());
        }
        return savedUser.getId();
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
                .orElseThrow(() -> new EntityNotFoundException("User not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> findAllPublicUsers() {
        return repository.findAllBySettingsIsPrivate(false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByUsername(String username) {
        return repository.findAllByUsernameContainingIgnoreCaseAndSettingsIsPrivate(username, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByUsername(String username) {
        return repository.findAllByUsernameContainingIgnoreCase(username)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByEmail(String email) {
        return repository.findAllByEmailAndSettingsIsPrivate(email, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByEmail(String email) {
        return repository.findAllByEmail(email)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByRole(String role) {
        return repository.findAllByRoleNameAndSettingsIsPrivate(role, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByRole(String role) {
        return repository.findAllByRoleName(role)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByGoals(String goals) {
        return repository.findAllBySettingsGoalsContainingAndSettingsIsPrivate(goals, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByGoals(String goals) {
        return repository.findAllBySettingsGoalsContaining(goals)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicBySenseiId(UUID id) {
        return repository.findAllBySenseiListIdAndSettingsIsPrivate(id, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllBySenseiId(UUID id) {
        return repository.findAllBySenseiListId(id)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicBySenseiUsername(String username) {
        return repository.findAllBySenseiListUsernameIgnoreCaseAndSettingsIsPrivate(
                username, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllBySenseiUsername(String username) {
        return repository.findAllBySenseiListUsernameIgnoreCase(username)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByStudentId(UUID id) {
        return repository.findAllByStudentsListIdAndSettingsIsPrivate(id, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByStudentId(UUID id) {
        return repository.findAllByStudentsListId(id)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByStudentUsername(String username) {
        return repository.findAllByStudentsListUsernameAndSettingsIsPrivate(username, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByStudentUsername(String username) {
        return repository.findAllByStudentsListUsername(username)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByContactId(UUID id) {
        return repository.findAllByContactsListIdAndSettingsIsPrivate(id, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByContactId(UUID id) {
        return repository.findAllByContactsListId(id)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPublicByContactUsername(String username) {
        return repository.findAllByStudentsListUsernameAndSettingsIsPrivate(username, false)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByContactUsername(String username) {
        return repository.findAllByStudentsListUsername(username)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findOnePublicById(UUID id) {
        return repository.findByIdAndSettingsIsPrivate(id, false)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id provided: " + id));
    }

    @Override
    public UserDto findOnePublicByEmail(String email) {
        return repository.findByEmailAndSettingsIsPrivate(email, false)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email provided: " + email));
    }

    @Override
    public UserDto findOneByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email provided: " + email));
    }

    @Override
    public UserDto findOnePublicByUsername(String username) {
        return repository.findByUsernameContainingIgnoreCaseAndSettingsIsPrivate(username, false)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username provided: " + username));
    }

    @Override
    public UserDto findOneByUsername(String username) {
        return repository.findByUsernameContainingIgnoreCase(username)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username provided: " + username));
    }

}
