package org.scouthub.usersender.infraestructure.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.usersender.application.CreateUser;
import org.scouthub.usersender.application.DeleteUser;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infraestructure.kafka.service.UserServiceImpl;
import org.scouthub.usersender.infraestructure.rest.dto.UserDeleteRequestDTO;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;
import org.scouthub.usersender.infraestructure.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {

  @Autowired UserMapper userMapper;

  @Autowired UserServiceImpl userService;

  @GetMapping("/")
  public void debug(HttpServletRequest request) {
    log.debug("Received request: {}", request.getRequestURI());
    System.out.println("Hello world");
  }

  @Override
  @PostMapping("/")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void createUser(@RequestBody UserRequestDTO userRequestDTO) {
    log.debug("Received request to create user");
    User user = userMapper.userRequestDTOToUser(userRequestDTO);
    CreateUser.create(user, userService);
  }

  @Override
  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void deleteUser(@PathVariable UserDeleteRequestDTO userDeleteRequestDTO) {
    log.debug("Received request to delete user");
    DeleteUser.delete(userDeleteRequestDTO.getId(), userService);
  }
}
