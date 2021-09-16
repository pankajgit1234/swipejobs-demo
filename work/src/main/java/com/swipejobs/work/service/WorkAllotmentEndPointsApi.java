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

import java.util.Collections;
import java.util.List;

/** Api that fetches the list of workers and list of jobs. */
@Component
public class WorkAllotmentEndPointsApi {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.worker.url}")
  private String workerUrl;

  @Value("${api.job.url}")
  private String jobsUrl;

  public List<Job> getAllJobs() {
    ResponseEntity<List<Job>> jobsResponseEntity = restTemplate.exchange(
        jobsUrl,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference() {
        });

    return Collections.unmodifiableList(jobsResponseEntity.getBody());
  }

  public List<Worker> getAllWorkers() {
    ResponseEntity<List<Worker>> workersResponseEntity = restTemplate.exchange(
        workerUrl,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference() {
        });

    return Collections.unmodifiableList(workersResponseEntity.getBody());
  }
}
