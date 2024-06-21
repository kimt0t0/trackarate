package com.kimdev.trackarate.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.Like;

public interface LikeRepository extends JpaRepository<Like, UUID> {
    // FIND MANY
    List<Like> findAllByUserId(UUID id);

    List<Like> findAllByUserIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByUserUsername(String id);

    List<Like> findAllByUserUsernameAndUserSettingsIsPrivate(String id, boolean isPrivate);

    List<Like> findAllByExerciseId(UUID id);

    List<Like> findAllByExerciseIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByTrainingProgramId(UUID id);

    List<Like> findAllByTrainingProgramIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    List<Like> findAllByTrainingSessionId(UUID id);

    List<Like> findAllByTrainingSessionIdAndUserSettingsIsPrivate(UUID id, boolean isPrivate);

    @Query(value = "select count(*) from likes l where l.createdDate between :startDate and :endDate", nativeQuery = true)
    Map<LocalDate, Integer> findCountLikesByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "select count(*) from likes l inner join users u on u.id = l.user_id where((u.id = :userId) and ( l.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findUserCountLikesByDate(LocalDate startDate, LocalDate endDate, UUID userId);

    @Query(value = "select count(l) from likes l inner join exercises e on l.exercise_id = e.id where ((e.id = :exerciseId) and (l.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findExerciseCountLikesByDate(LocalDate startDate, LocalDate endDate,
            UUID exerciseId);

    @Query(value = "select count(l) from likes l inner join training_sessions s on l.exercise_id = s.id where ((s.id = :sessionId) and (l.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findSessionCountLikesByDate(LocalDate startDate, LocalDate endDate,
            UUID sessionId);

    @Query(value = "select count(l) from likes l inner join training_programs p on l.exercise_id = p.id where ((p.id = :programId) and (l.createdDate between :startDate and :endDate))", nativeQuery = true)
    Map<LocalDate, Integer> findProgramCountLikesByDate(LocalDate startDate, LocalDate endDate,
            UUID programId);

    // FIND ONE
    Like findOneById(UUID id);
}
