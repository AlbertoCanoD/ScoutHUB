package org.scouthub.usersender.infraestructure.rest.dto;

import lombok.*;
import org.scouthub.usersender.domain.model.Branch;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
  private Long id;
  private String name;
  private int age;
  private Branch branch;
}
