package org.scouthub.activitysender.infraestructure.rest.controller;

import javax.validation.Valid;
import org.scouthub.activitysender.infraestructure.rest.dto.ActivityRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface ActivityController {

  @PostMapping(value = "/activity")
  @ResponseStatus(HttpStatus.ACCEPTED)
  void createActivity(@Valid @RequestBody ActivityRequestDTO activityRequestDTO);

  @DeleteMapping(value = "/activity/{activityId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  void deleteActivity(@PathVariable Long id);
}
