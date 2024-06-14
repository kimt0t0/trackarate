package com.kimdev.trackarate.services;

import java.util.UUID;

import com.kimdev.trackarate.dto.SettingsDto;

public interface SettingsService extends AbstractService<SettingsDto> {

    UUID initializeUserSettings(UUID userId);

    SettingsDto findOneByUserId(UUID userId);

}
