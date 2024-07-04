package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.AvatarDto;

public interface AvatarService extends AbstractService<AvatarDto> {

    // FIND MANY
    List<AvatarDto> findAllPublic();

    // FIND ONE
    AvatarDto findOnePublic(UUID id);

    AvatarDto findOneByUserId(UUID id);

    AvatarDto findOnePublicByUserId(UUID id);

    AvatarDto findOneByUserUsername(String username);

    AvatarDto findOnePublicByUserUsername(String username);
}
