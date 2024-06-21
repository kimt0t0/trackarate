package com.kimdev.trackarate.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kimdev.trackarate.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    // FIND MANY
    List<User> findAll();

    List<User> findAllBySettingsIsPrivate(boolean isPrivate);

    List<User> findAllByUsernameContainingIgnoreCase(String username);

    List<User> findAllByUsernameContainingIgnoreCaseAndSettingsIsPrivate(String username, boolean isPrivate);

    List<User> findAllBySettingsGoalsContaining(String goals);

    List<User> findAllBySettingsGoalsContainingAndSettingsIsPrivate(String goals, boolean isPrivate);

    List<User> findAllByEmail(String email);

    List<User> findAllByEmailAndSettingsIsPrivate(String email, boolean isPrivate);

    List<User> findAllByRoleName(String name);

    List<User> findAllByRoleNameAndSettingsIsPrivate(String name, boolean isPrivate);

    List<User> findAllBySenseiListId(UUID id);

    List<User> findAllBySenseiListIdAndSettingsIsPrivate(UUID id, boolean isPrivate);

    List<User> findAllBySenseiListUsernameIgnoreCase(String name);

    List<User> findAllBySenseiListUsernameIgnoreCaseAndSettingsIsPrivate(String name, boolean isPrivate);

    List<User> findAllByStudentsListId(UUID id);

    List<User> findAllByStudentsListIdAndSettingsIsPrivate(UUID id, boolean isPrivate);

    List<User> findAllByStudentsListUsername(String username);

    List<User> findAllByStudentsListUsernameAndSettingsIsPrivate(String username, boolean isPrivate);

    List<User> findAllByContactsListId(UUID id);

    List<User> findAllByContactsListIdAndSettingsIsPrivate(UUID id, boolean isPrivate);

    List<User> findAllByContactsListUsername(String username);

    List<User> findAllByContactsListUsernameAndSettingsIsPrivate(String username, boolean isPrivate);

    // COUNTS
    @Query(value = "select count(*) from users", nativeQuery = true)
    Integer getUsersCount();

    @Query(value = "select count(u) from users u inner join role r on u.role_id = r.id where r.id = :roleId", nativeQuery = true)
    Integer getUsersCountByRole(UUID roleId);

    // FIND ONE
    @SuppressWarnings("null")
    Optional<User> findById(UUID id);

    @SuppressWarnings("null")
    Optional<User> findByIdAndSettingsIsPrivate(UUID id, boolean isPrivate);

    @SuppressWarnings("null")
    Optional<User> findByUsernameContainingIgnoreCase(String username);

    @SuppressWarnings("null")
    Optional<User> findByUsernameContainingIgnoreCaseAndSettingsIsPrivate(String username, boolean isPrivate);

    @SuppressWarnings("null")
    Optional<User> findByEmail(String email);

    @SuppressWarnings("null")
    Optional<User> findByEmailAndSettingsIsPrivate(String email, boolean isPrivate);

}