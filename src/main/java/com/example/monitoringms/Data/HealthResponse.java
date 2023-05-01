package com.example.monitoringms.Data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthResponse {
    private String status;
    private Object components;

    public HealthResponse() {}

}
