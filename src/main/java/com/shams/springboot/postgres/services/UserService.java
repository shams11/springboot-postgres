package com.shams.springboot.postgres.services;

import com.shams.springboot.postgres.entities.UserEntity;

import java.util.List;

public interface UserService {
  UserEntity create(UserEntity build);

  List<UserEntity> getAllUsers();

  String getUserById(long id);
}
