package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

import com.kimdev.trackarate.dto.UserDto;

public interface UserService extends AbstractService<UserDto> {

    // FIND MANY
    List<UserDto> findAllPublicUsers();

    List<UserDto> findAllPublicByUsername(String username);

    List<UserDto> findAllByUsername(String username);

    List<UserDto> findAllPublicByEmail(String email);

    List<UserDto> findAllByEmail(String email);

    List<UserDto> findAllPublicByRole(String role);

    List<UserDto> findAllByRole(String role);

    List<UserDto> findAllPublicByGoals(String goals);

    List<UserDto> findAllByGoals(String goals);

    List<UserDto> findAllPublicBySenseiId(UUID id);

    List<UserDto> findAllBySenseiId(UUID id);

    List<UserDto> findAllPublicBySenseiUsername(String username);

    List<UserDto> findAllBySenseiUsername(String username);

    List<UserDto> findAllPublicByStudentId(UUID id);

    List<UserDto> findAllByStudentId(UUID id);

    List<UserDto> findAllPublicByStudentUsername(String username);

    List<UserDto> findAllByStudentUsername(String username);

    List<UserDto> findAllPublicByContactId(UUID id);

    List<UserDto> findAllByContactId(UUID id);

    List<UserDto> findAllPublicByContactUsername(String username);

    List<UserDto> findAllByContactUsername(String username);

    // FIND ONE

    UserDto findOnePublicById(UUID id);

    UserDto findOnePublicByEmail(String email);

    UserDto findOneByEmail(String email);

    UserDto findOnePublicByUsername(String username);

    UserDto findOneByUsername(String username);

}
