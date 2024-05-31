package com.kimdev.trackarate.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Settings;

public interface SettingsRepository extends JpaRepository<Settings, UUID> {
    Settings findOneByUserId(UUID id);
}
