package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Type;

public interface TypeRepository extends JpaRepository<Type, UUID> {

    List<Type> findAll();
}