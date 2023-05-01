package com.example.monitoringms.controllers;

import com.example.monitoringms.service.DataDumpsService;
import com.example.monitoringms.service.HealthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataDumpsController {
    private final DataDumpsService dataDumpsService;

    public DataDumpsController(DataDumpsService dataDumpsService) {
        this.dataDumpsService = dataDumpsService;
    }

    @GetMapping("/dumps")
    public ResponseEntity<Object> getMicroserviceDataDumps(@Valid @RequestParam("interval") Integer checkInterval) {
        log.debug("Fetching Health Data for microservices");
        Object heapDump = dataDumpsService.getMicroserviceHeapDump(checkInterval).blockingFirst();
        Object threadDump = dataDumpsService.getMicroserviceThreadDump(checkInterval).blockingFirst();

        return ResponseEntity.ok(heapDump);
    }
}
