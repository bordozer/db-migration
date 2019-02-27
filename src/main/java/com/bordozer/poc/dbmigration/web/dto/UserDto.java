package com.bordozer.poc.dbmigration.web.dto;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(
        onConstructor = @__({@ConstructorProperties({
                "userId", "userName", "userAge", "birthday"
        })}))
@Getter
@Builder
@ToString
public class UserDto {

    @NonNull
    private final Long userId;
    @NonNull
    @NotBlank
    private final String userName;
    @NonNull
    private final Integer userAge;
    @NonNull
    private final LocalDate birthday;
}
