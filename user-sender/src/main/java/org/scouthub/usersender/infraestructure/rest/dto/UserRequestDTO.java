package org.scouthub.usersender.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDTO {
  Long id;
  String name;
  int age;
  String branch;
}
