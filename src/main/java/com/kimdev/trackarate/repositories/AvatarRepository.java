package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, UUID> {
    // FIND MANY
    List<Avatar> findAll();

    List<Avatar> findAllByUserSettingsIsPrivate(boolean isPrivate);

    // FIND ONE
    Avatar findOneById(UUID id);

    Avatar findOneByUserId(UUID id);

    Avatar findOneByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Avatar findOneByUserUsername(String username);

    Avatar findOneByUserUsernameAndUserSettingsIsPrivate(String username, boolean isPrivate);

}
