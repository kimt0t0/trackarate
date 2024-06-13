package com.kimdev.trackarate.services.implementations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimdev.trackarate.dto.RoleDto;
import com.kimdev.trackarate.models.Role;
import com.kimdev.trackarate.repositories.RoleRepository;
import com.kimdev.trackarate.services.RoleService;
import com.kimdev.trackarate.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final ObjectsValidator<RoleDto> validator;

    @Override
    public UUID save(RoleDto dto) {
        validator.validate(dto);
        Role role = RoleDto.toEntity(dto);
        return repository.save(role).getId();
    }

    @Override
    public List<RoleDto> findAll() {
        return repository.findAll()
                .stream()
                .map(RoleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(UUID id) {
        return repository.findById(id)
                .map(RoleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with provided id: " + id));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
