package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.enums.MediaType;
import com.kimdev.trackarate.models.Media;

public interface MediaRepository extends JpaRepository<Media, UUID> {
    // FIND MANY
    List<Media> findAll();

    List<Media> findAllByUserSettingsIsPrivate(boolean isPrivate);

    List<Media> findAllByExerciseId(UUID id);

    List<Media> findAllByExerciseIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Media> findAllByExerciseTitleContainingIgnoreCase(String title);

    List<Media> findAllByExerciseTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title, boolean isPrivate);

    List<Media> findAllByTitleContainingIgnoreCase(String title);

    List<Media> findAllByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title, boolean isPrivate);

    List<Media> findAllByTitleContainingIgnoreCaseAndType(String title, MediaType type);

    List<Media> findAllByTitleContainingIgnoreCaseAndTypeAndUserSettingsIsPrivate(String title, MediaType type,
            boolean isPrivate);

    @Query(value = "select * from media where ((title ilike %:search%) or (description ilkike %:search%))", nativeQuery = true)
    List<Media> findAllByTitleOrDescription(String search);

    @Query(value = "select * from media m inner join user u inner join settings s on u.id = m.user_id and u.id = s.user_id where (((m.title ilike %:search%) or (m.description ilkike %:search%)) and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<Media> findAllByTitleOrDescriptionAndUserSettingsIsPrivate(String search, boolean isPrivate);

    @Query(value = "select * from media m inner where(((title ilike %:search%) or (description ilike %:search)) and (type = :type))", nativeQuery = true)
    List<Media> findAllByTitleOrDescriptionAndType(String search, MediaType type);

    @Query(value = "select * from media m inner join user u inner join settings s on u.id = m.user_id and u.id = s.user_id where((((m.title ilike %:search%) or (m.description ilike %:search)) and (m.type = :type)) and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<Media> findAllByTitleOrDescriptionAndTypeAndUserSettingsIsPrivate(String search, MediaType type,
            boolean isPrivate);

    // FIND ONE
    Media findOneById(UUID id);

    Media findOneByIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    Media findOneByTitleContainingIgnoreCase(String title);

    Media findOneByTitleContainingIgnoreCaseAndUserSettingsIsPrivate(String title, boolean isPrivate);

    Media findOneByTitleContainingIgnoreCaseAndUserId(String title, UUID id);

    Media findOneByTitleContainingIgnoreCaseAndUserUsername(String title, String username);

    Media findOneByTitleContainingIgnoreCaseAndUserUsernameAndUserSettingsIsPrivate(String title, String username,
            boolean isPrivate);

}
