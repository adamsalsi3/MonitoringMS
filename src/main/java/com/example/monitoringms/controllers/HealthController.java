package com.example.monitoringms.controllers;

import com.example.monitoringms.service.HealthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @Scheduled(fixedDelay = 5000)
    @GetMapping("/health")
    public ResponseEntity<Object> getMicroserviceHealth(@Valid @RequestParam("interval") Integer checkInterval) {
        log.debug("Fetching Health Data for microservices");
        Object health = healthService.getMicroserviceHealth(checkInterval).blockingFirst().getComponents();
        return ResponseEntity.ok(health);
    }

}
