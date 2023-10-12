package org.scouthub.apiuser.infraestructure.rest.controller;

import java.util.List;
import org.scouthub.apiuser.application.GetAllUsers;
import org.scouthub.apiuser.application.GetUser;
import org.scouthub.apiuser.domain.exception.UserNotFound;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;
import org.scouthub.apiuser.infraestructure.rest.dto.GetUserResponseDTO;
import org.scouthub.apiuser.infraestructure.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

  @Autowired UserRepository userRepository;

  @Autowired UserMapper userMapper;

  @Override
  @GetMapping(value = "/user")
  public ResponseEntity<Object> getAllUsers() {
    List<User> users = GetAllUsers.get(userRepository);
    List<GetUserResponseDTO> getUserResponseDTO =
        userMapper.userListToGetUserResponseDTOList(users);
    return ResponseEntity.status(HttpStatus.OK).body(getUserResponseDTO);
  }

  @Override
  @GetMapping(value = "/user/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable Long id) throws UserNotFound {
    User user = GetUser.get(id, userRepository);
    GetUserResponseDTO getUserResponseDTO = userMapper.userToGetUserResponseDTO(user);
    return ResponseEntity.status(HttpStatus.OK).body(getUserResponseDTO);
  }
}
