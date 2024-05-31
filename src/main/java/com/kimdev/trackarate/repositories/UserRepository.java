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

    List<User> findAllByUsernameContainingIgnoreCase(String username);

    List<User> findAllByUsernameContainingIgnoreCaseAndSettingsIsPrivate(String username, boolean isPrivate);

    @Query(value = "select * from users where beltOrGrade ilike %:beltOrGrade%", nativeQuery = true)
    List<User> findAllByBeltOrGradeContainingIgnoreCase(String beltOrGrade);

    @Query(value = "select * from users u inner join settings s on u.id = s.user_id where (u.beltOrGrade ilike %:beltOrGrade% and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<User> findAllByBeltOrGradeContainingIgnoreCaseAndSettingsIsPrivate(String beltOrGrade, boolean isPrivate);

    List<User> findAllBySettingsGoalsContaining(String goals);

    List<User> findAllBySettingsGoalsContainingAndSettingsIsPrivate(String goals, boolean isPrivate);

    List<User> findAllByEmail(String email);

    List<User> findAllByEmailAndSettingsIsPrivate(String email, boolean isPrivate);

    List<User> findAllByRoleName(String name);

    List<User> findAllByRoleNameAndSettingsIsPrivate(String name, boolean isPrivate);

    @Query(value = "select * from users u inner join roles r on u.id and r.user_id where(u.beltOrGrade ilike %:beltOrGrade% and r.name = :name)", nativeQuery = true)
    List<User> findAllByBeltOrGradeAndRoleName(String beltOrGrade, String name);

    @Query(value = "select * from users u inner join roles r inner join settings s on u.id and r.user_id and u.id = s.user_id where(u.beltOrGrade ilike %:beltOrGrade% and r.name = :name and s.isPrivate = :isPrivate)", nativeQuery = true)
    List<User> findAllByBeltOrGradeAndRoleNameAndSettingsIsPrivate(String beltOrGrade, String name,
            boolean isPrivate);

    List<User> findAllBySenseiListUsernameAndSettingsIsPrivate(String username, boolean isPrivate);

    List<User> findAllByStudentsListUsername(String username);

    List<User> findAllByStudentsListUsernameAndSettingsIsPrivate(String username, boolean isPrivate);

    List<User> findAllByContactsListUsername(String username);

    List<User> findAllByContactsListUsernameAndSettingsIsPrivate(String username, boolean isPrivate);

    // FIND ONE
    User findOneById(UUID id);

    User findOneByIdAndSettingsIsPrivate(UUID id, boolean isPrivate);

    User findOneByUsernameContainingIgnoreCase(String username);

    User findOneByUsernameContainingIgnoreCaseAndSettingsIsPrivate(String username, boolean isPrivate);

    User findOneByEmail(String email);

    User findOneByEmailAndSettingsIsPrivate(String email, boolean isPrivate);

    User findOneByMediaListUserId(UUID id);

    User findOneByMediaListUserIdAndSettingsIsPrivate(UUID id, boolean isPrivate);
}