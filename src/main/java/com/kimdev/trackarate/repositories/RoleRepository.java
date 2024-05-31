package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAll();

    List<Role> findAllByNameContainingIgnoreCase(String name);

    Role findOneByNameContainingIgnoreCase(String name);
}
