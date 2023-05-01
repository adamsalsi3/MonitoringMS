package com.example.monitoringms.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PrometheusMetrics {
/*
    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    private static final Counter requests = Counter.build()
            .name("http_requests_total")
            .help("Total number of HTTP requests.")
            .labelNames("service")
            .register();

    private static final Gauge requestsInProgress = Gauge.build()
            .name("http_requests_in_progress")
            .help("Number of in-progress HTTP requests.")
            .labelNames("service")
            .register();

    public void incrementRequestCount(String serviceName) {
        requests.labels(serviceName).inc();
        counterService.increment("http_requests_total");
    }

    public void decrementRequestCount(String serviceName) {
        requests.labels(serviceName).dec();
    }

    public void incrementRequestsInProgress(String serviceName) {
        requestsInProgress.labels(serviceName).inc();
        gaugeService.submit("http_requests_in_progress", requestsInProgress.get(), "service", serviceName);
    }

    public void decrementRequestsInProgress(String serviceName) {
        requestsInProgress.labels(serviceName).dec();
        gaugeService.submit("http_requests_in_progress", requestsInProgress.get(), "service", serviceName);
    }

 */
}