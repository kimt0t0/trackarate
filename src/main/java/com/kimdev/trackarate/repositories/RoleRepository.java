package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    @SuppressWarnings("null")
    List<Role> findAll();

    List<Role> findAllByNameContainingIgnoreCase(String name);

    Optional<Role> findOneByNameContainingIgnoreCase(String name);
}
