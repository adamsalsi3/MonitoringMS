package com.example.monitoringms;

import de.codecentric.boot.admin.config.EnableAdminServer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAdminServer
@EnableDiscoveryClient
@OpenAPIDefinition(info =
@Info(title = "MonitoringMS", version = "1.0", description = "This Microservice is responsible for " +
        "the monitorization of the 'Powerpay' ecosystem Microservices")
)
public class MonitoringMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringMsApplication.class, args);
    }

}
