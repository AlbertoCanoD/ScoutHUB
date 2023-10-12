package org.scouthub.apiuser.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetUserResponseDTO {
  Long id;
  String name;
  int age;
  String branch;
}
