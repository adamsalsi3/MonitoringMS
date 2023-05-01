package com.example.monitoringms.service;

import com.example.monitoringms.Data.HealthResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class DataDumpsService {
    private String threadDumpUrl = "http://che4ppayapi01.cheadds.ca:8708/timeoff/pphr-monitor/threaddump";
    private String heapDumpUrl = "http://che4ppayapi01.cheadds.ca:8708/timeoff/pphr-monitor/heapdump";

    private final RestTemplate restTemplate = new RestTemplate();

    public Flowable<Object> getMicroserviceThreadDump(int intervalSeconds) {
        return Flowable.interval(0, intervalSeconds, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .flatMapMaybe(tick -> {
                    try {
                        Object response = restTemplate.getForObject(threadDumpUrl, Object.class);
                        return Maybe.just(response);
                    } catch (Exception e) {
                        return Maybe.empty();
                    }
                });
    }

    public Flowable<Object> getMicroserviceHeapDump(int intervalSeconds) {
        return Flowable.interval(0, intervalSeconds, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .flatMapMaybe(tick -> {
                    try {
                        Object response = restTemplate.getForObject(heapDumpUrl, Object.class);
                        return Maybe.just(response);
                    } catch (Exception e) {
                        return Maybe.empty();
                    }
                });
    }
}
