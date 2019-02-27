package com.bordozer.poc.dbmigration.service;

import java.util.List;

import com.bordozer.poc.dbmigration.web.dto.UserDto;

public interface UserService {

    List<UserDto> getAllUsers();
}
