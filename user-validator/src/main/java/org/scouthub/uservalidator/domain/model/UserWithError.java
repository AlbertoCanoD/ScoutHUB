package org.scouthub.uservalidator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithError {
  Long id;
  String name;
  int age;
  String branch;
  String error;
}
