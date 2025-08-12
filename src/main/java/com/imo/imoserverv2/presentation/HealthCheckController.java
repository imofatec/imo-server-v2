package com.imo.imoserverv2.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "health check")
@RestController
@RequestMapping("/api")
public class HealthCheckController {
  @GetMapping
  public ResponseEntity<String> handle() {
    return ResponseEntity.ok().body("Server is running");
  }
}
