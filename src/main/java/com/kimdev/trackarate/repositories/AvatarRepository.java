package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimdev.trackarate.models.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, UUID> {
    // FIND MANY
    List<Avatar> findAll();

    List<Avatar> findAllByUserSettingsIsPrivate(boolean isPrivate);

    // FIND ONE
    Optional<Avatar> findOneById(UUID id);

    Optional<Avatar> findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Optional<Avatar> findOneByUserId(UUID id);

    Optional<Avatar> findOneByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Optional<Avatar> findOneByUserUsername(String username);

    Optional<Avatar> findOneByUserUsernameAndUserSettingsIsPrivate(String username, boolean isPrivate);

}
