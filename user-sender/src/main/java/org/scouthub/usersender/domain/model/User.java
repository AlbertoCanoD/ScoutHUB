package org.scouthub.usersender.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  private String name;
  private Branch branch;
}