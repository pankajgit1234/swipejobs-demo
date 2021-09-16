package com.swipejobs.work.service;

import com.swipejobs.work.model.Job;
import com.swipejobs.work.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ServiceHardening {

    @Autowired
    private RestTemplate restTemplate;

   @Value("${api.worker.url}")
    private String workerUrl;

    @Value("${api.job.url}")
    private String jobsUrl;

    public List<Job> getAllJobs() {
        ResponseEntity<List<Job>> responseEntity1 = restTemplate.exchange(
                jobsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Job>>() {
                });
        List<Job> jobsList = responseEntity1.getBody();
        return jobsList;
    }

    public List<Worker> getAllWorkers() {
        ResponseEntity<List<Worker>> responseEntity = restTemplate.exchange(
                workerUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Worker>>() {
                });
        List<Worker> workersList = responseEntity.getBody();
        return workersList;
    }
}
