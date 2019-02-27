package com.bordozer.poc.dbmigration.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bordozer.poc.dbmigration.service.UserService;
import com.bordozer.poc.dbmigration.web.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        LOGGER.info("Get all users request");

        final List<UserDto> users = userService.getAllUsers();

        LOGGER.info("All users response", users);

        return ResponseEntity.ok(users);
    }
}
