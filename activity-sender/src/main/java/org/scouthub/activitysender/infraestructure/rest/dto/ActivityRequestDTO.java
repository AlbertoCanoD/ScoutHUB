package org.scouthub.activitysender.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActivityRequestDTO {
  Long id;
  String name;
  String description;
}
