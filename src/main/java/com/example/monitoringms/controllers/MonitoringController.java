package com.example.monitoringms.controllers;

import com.example.monitoringms.Data.Microservice;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/monitor")
public class MonitoringController {
    private Map<String, Microservice> microservices = new HashMap<>();

    @PostMapping("/{microserviceName}")
    public void reportHealth(
            @PathVariable String microserviceName,
            @RequestBody Microservice microservice
    ) {
        microservices.put(microserviceName, microservice);
    }

    @GetMapping("/metrics")
    public Map<String, Microservice> getMetrics() {
        return microservices;
    }
}
