package org.scouthub.materialsender.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MaterialRequestDTO {
    Long id;
    String name;
    int cuantity;
    float price;
}
