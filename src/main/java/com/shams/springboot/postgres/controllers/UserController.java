package com.shams.springboot.postgres.controllers;

import com.shams.springboot.postgres.entities.UserEntity;
import com.shams.springboot.postgres.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE
  )
  @ResponseStatus(HttpStatus.CREATED)
  public UserEntity create(@RequestBody UserEntity userEntity) {
    return userService.create(
        UserEntity.builder()
        .firstName(userEntity.getFirstName())
        .lastName(userEntity.getLastName()).build());
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> getAllUsers() {
    return userService.getAllUsers();
  }

  @RequestMapping("/{id}")
  public String search(@PathVariable long id) {
    return userService.getUserById(id);
  }
}
