package com.kimdev.trackarate.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kimdev.trackarate.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 26)
    private String username;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    @Size(min = 6, max = 120)
    private String email;

    @Size(min = 10, max = 13)
    private String phone;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    private List<UUID> senseiListIds;

    private List<UUID> studentsListIds;

    private List<UUID> contactsListIds;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .senseiListIds(
                        user.getSenseiList()
                                .stream()
                                .map(User::getId)
                                .collect(Collectors.toList()))
                .studentsListIds(
                        user.getStudentsList()
                                .stream()
                                .map(User::getId)
                                .collect(Collectors.toList()))
                .contactsListIds(
                        user.getContactsList()
                                .stream()
                                .map(User::getId)
                                .collect(Collectors.toList()))
                .build();
    }

    public static User toEntity(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .password(userDto.getPassword())
                .build();

        List<User> senseiList = userDto.getSenseiListIds()
                .stream()
                .map(id -> User.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<User> studentsList = userDto.getStudentsListIds()
                .stream()
                .map(id -> User.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        List<User> contactsList = userDto.getContactsListIds()
                .stream()
                .map(id -> User.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());

        user.setSenseiList(senseiList);
        user.setStudentsList(studentsList);
        user.setContactsList(contactsList);

        return user;
    }

}
