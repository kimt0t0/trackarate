package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    // FIND MANY
    List<User> findAll();

    List<User> findAllBySettingsIsPrivate(boolean isPrivate);

    List<User> findAllByUsernameContainingIgnoreCaseAndSettingsIsPrivate(String username, boolean isPrivate);

    List<User> findAllByUsernameContainingIgnoreCase(String username);

    @Query(value = "select * from users u inner join settings s on u.id = s.user_id and u.beltOrGrade = :beltOrGrade and s.isPrivate = :isPrivate", nativeQuery = true)
    List<User> findAllByBeltOrGradeContainingAndSettingsIsPrivate(String beltOrGrade, boolean isPrivate);

    List<User> findAllBySettingsGoalsContaining(String goals);

    List<User> findAllByEmail(String email);

    List<User> findAllByRoleName(String name);

    @Query(value = "select * from users u inner join roles r on u.id and r.user_id and u.beltOrGrade = :beltOrGrade and r.name = :name", nativeQuery = true)
    List<User> findAllByBeltOrGradeContainingIgnoreCaseAndRoleName(String beltOrGrade, String name);

    List<User> findAllBySenseiListUsername(String username);

    List<User> findAllByStudentsListUsername(String username);

    List<User> findAllByContactsListUsername(String username);

    // FIND ONE
    User findOneById(UUID id);

    User findOneByUsernameContainingIgnoreCase(String username);

    User findOneByEmail(String email);
}