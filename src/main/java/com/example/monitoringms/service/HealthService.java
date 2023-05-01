package com.example.monitoringms.service;

import com.example.monitoringms.Data.HealthResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class HealthService {

    //@Value("microservice.actuator.service.baseurl")
    private String healthUrl = "http://che4ppayapi01.cheadds.ca:8708/timeoff/pphr-monitor/health";

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * getMicroserviceHealth method uses RxJava to create a Flowable that emits HealthResponse
     * objects at regular intervals, with the possibility of emitting null or empty values depending on the
     * response from the microservice URL. This allows it to monitor the health of the endpoint over time.
     * Switch to using IO bound scheduler to avoid "thread blocking"
     * @param intervalSeconds -> How often to proc the health check
     * @return -> A flowable (stream of reactive data) that can signal completion or error on the health of our APIs
     */
    public Flowable<HealthResponse> getMicroserviceHealth(int intervalSeconds) {
        return Flowable.interval(0, intervalSeconds, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .flatMapMaybe(tick -> {
            try {
                HealthResponse response = restTemplate.getForObject(healthUrl, HealthResponse.class);
                return Maybe.just(response);
            } catch (Exception e) {
                return Maybe.empty();
            }
        });
    }
}
