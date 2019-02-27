package com.bordozer.poc.dbmigration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bordozer.poc.dbmigration.converter.UserConverter;
import com.bordozer.poc.dbmigration.repository.UserRepository;
import com.bordozer.poc.dbmigration.service.UserService;
import com.bordozer.poc.dbmigration.web.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Value(value = "${application.properties.schema}")
    private String schema;

    @Override
    public List<UserDto> getAllUsers() {
        return UserConverter.convertToDtos(userRepository.getAllUsers(schema));
    }
}
