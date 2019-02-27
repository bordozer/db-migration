package com.bordozer.poc.dbmigration.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bordozer.poc.dbmigration.domain.User;

@Mapper
public interface UserRepository {

    List<User> getAllUsers(@Param("schema") String schema);
}
