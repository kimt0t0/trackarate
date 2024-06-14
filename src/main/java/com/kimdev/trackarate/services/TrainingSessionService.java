package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.TrainingSessionDto;

public interface TrainingSessionService extends AbstractService<TrainingSessionDto> {

    List<TrainingSessionDto> findAllByUserId(UUID id);

}
