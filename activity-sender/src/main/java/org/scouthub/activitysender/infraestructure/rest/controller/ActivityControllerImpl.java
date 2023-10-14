package org.scouthub.activitysender.infraestructure.rest.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.activitysender.application.CreateActivity;
import org.scouthub.activitysender.application.DeleteActivity;
import org.scouthub.activitysender.domain.model.Activity;
import org.scouthub.activitysender.infraestructure.kafka.service.ActivityServiceImpl;
import org.scouthub.activitysender.infraestructure.rest.dto.ActivityRequestDTO;
import org.scouthub.activitysender.infraestructure.rest.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ActivityControllerImpl implements ActivityController {
  @Autowired ActivityMapper activityMapper;

  @Autowired ActivityServiceImpl activityService;

  @Override
  @PostMapping(value = "/activity")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void createActivity(@Valid @RequestBody ActivityRequestDTO activityRequestDTO) {
    log.debug("Received request to create activity");
    Activity activity = activityMapper.activityRequestDTOToActivity(activityRequestDTO);
    CreateActivity.create(activity, activityService);
  }

  @Override
  @DeleteMapping(value = "/activity/{activityId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void deleteActivity(@PathVariable Long id) {
    log.debug("Received request to delete activity");
    DeleteActivity.delete(id, activityService);
  }
}
