package org.scouthub.usersender.infraestructure.rest.dto;

import lombok.*;
import org.scouthub.usersender.domain.model.Branch;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteRequestDTO {
  private Long id;
}