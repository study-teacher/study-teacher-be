package com.fridge.studyteacherbe.global.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HealthCheckController {

  @GetMapping
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("I'm Healthy!");
  }

}
