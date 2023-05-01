package com.example.monitoringms.configuration;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusProperties;
import org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusProperties.Pushgateway;
import org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusMetricsExportAutoConfiguration.PrometheusScrapeEndpointConfiguration;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusPushGatewayManager;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;


public class PrometheusConfig {
/*
    @Value("${prometheus.pushgateway.enabled:false}")
    private boolean pushgatewayEnabled;

    @Bean
    public CollectorRegistry collectorRegistry() {
        return new CollectorRegistry();
    }

    @Bean
    public MeterRegistry prometheusRegistry(CollectorRegistry collectorRegistry) {
        return new PrometheusMeterRegistry(collectorRegistry, Clock.SYSTEM) {
            @Override
            private Double nullGaugeValue() {
                return Double.NaN;
            }
        };
    }

    @Bean
    public PrometheusScrapeEndpoint prometheusScrapeEndpoint(CollectorRegistry collectorRegistry, PrometheusProperties properties) {
        return new PrometheusScrapeEndpoint(collectorRegistry, properties);
    }

    @Bean
    public PrometheusScrapeEndpointHandlerMapping prometheusScrapeEndpointHandlerMapping(PrometheusScrapeEndpoint prometheusScrapeEndpoint) {
        return new PrometheusScrapeEndpointHandlerMapping(prometheusScrapeEndpoint);
    }

    @Bean
    public PrometheusPushGatewayManager prometheusPushGatewayManager(PrometheusProperties properties, CollectorRegistry collectorRegistry, RestTemplate restTemplate) {
        return new PrometheusPushGatewayManager(properties.getConfig(), collectorRegistry, restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public StepMeterRegistry stepMeterRegistry(CollectorRegistry collectorRegistry) {
        return new StepMeterRegistry(null, Clock.SYSTEM, collectorRegistry, null, 1, 1, false) {
            @Override
            protected TimeUnit getBaseTimeUnit() {
                return null;
            }

            @Override
            protected void publish() {

            }
        };
    }

 */
}
