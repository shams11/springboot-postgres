package com.shams.springboot.postgres.services.impl;

import com.shams.springboot.postgres.entities.UserEntity;
import com.shams.springboot.postgres.repositories.UserRepository;
import com.shams.springboot.postgres.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserEntity create(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return new ArrayList<>(userRepository.findAll());
  }

  @Override
  public String getUserById(long id) {
    return userRepository.findById(id).toString();
  }
}
