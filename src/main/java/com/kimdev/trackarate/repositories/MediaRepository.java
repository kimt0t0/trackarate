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

    List<Media> findAllByExerciseId(UUID id);

    List<Media> findAllByTitleContainingIgnoreCase(String title);

    List<Media> findAllByTitleContainingIgnoreCaseAndType(String title, MediaType type);

    @Query(value = "select * from media where ((title ilike %:search%) or (description ilkike %:search%))", nativeQuery = true)
    List<Media> findAllByTitleOrDescription(String search);

    @Query(value = "select * from media m inner where(((title ilike %:search%) or (description ilike %:search)) and (type = :type))", nativeQuery = true)
    List<Media> findAllByTitleContainingIgnoreCaseOrDescriptionIgnoreCaseAndType(String search, MediaType type);

    // FIND ONE
    Media findOneById(UUID id);
}
