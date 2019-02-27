package com.bordozer.poc.dbmigration.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.bordozer.poc.dbmigration.domain.User;
import com.bordozer.poc.dbmigration.web.dto.UserDto;

public final class UserConverter {

    private UserConverter() {
    }

    public static List<UserDto> convertToDtos(final List<User> users) {
        return users.stream()
                .map(UserConverter::convertToDto)
                .collect(Collectors.toList());
    }

    private static UserDto convertToDto(final User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUsername())
                .userAge(user.getAge())
                .birthday(user.getBirthday().toLocalDate())
                .build();
    }
}
