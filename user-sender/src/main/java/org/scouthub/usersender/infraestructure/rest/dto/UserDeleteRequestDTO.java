package org.scouthub.usersender.infraestructure.rest.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteRequestDTO {
  // TODO - Check if this is the correct way to do this, is better give the ID directly or the whole
  // object?
  Long id;
}
