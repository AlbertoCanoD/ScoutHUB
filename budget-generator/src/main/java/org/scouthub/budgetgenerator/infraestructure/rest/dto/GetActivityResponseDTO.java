package org.scouthub.budgetgenerator.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetActivityResponseDTO {
  Long id;
  String name;
  String description;
}
