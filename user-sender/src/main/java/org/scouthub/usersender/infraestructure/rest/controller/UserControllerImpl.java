package org.scouthub.usersender.infraestructure.rest.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.usersender.application.CreateUser;
import org.scouthub.usersender.application.DeleteUser;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infraestructure.kafka.service.UserServiceImpl;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;
import org.scouthub.usersender.infraestructure.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserControllerImpl implements UserController {

  @Autowired UserMapper userMapper;

  @Autowired UserServiceImpl userService;

  @Override
  @PostMapping(value = "/user")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
    log.debug("Received request to create user");
    User user = userMapper.userRequestDTOToUser(userRequestDTO);
    CreateUser.create(user, userService);
  }

  @Override
  @DeleteMapping(value = "/user/{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable Long userId) {
    log.debug("Received request to delete user");
    DeleteUser.delete(userId, userService);
  }
}
