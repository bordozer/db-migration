package com.bordozer.poc.dbmigration.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private Long userId;
    @NonNull
    private String username;
    @NonNull
    private Integer age;
    @NonNull
    private LocalDateTime birthday;
}
