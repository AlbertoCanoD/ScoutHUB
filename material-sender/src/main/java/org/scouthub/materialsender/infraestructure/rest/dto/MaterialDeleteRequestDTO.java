package org.scouthub.materialsender.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("unused")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDeleteRequestDTO {
  Long id;
}
