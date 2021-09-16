package com.swipejobs.work.service;

import com.swipejobs.work.model.JobDetails;

import java.util.List;

/**
 * Service that can be injected to fetch the appropriate jobs.
 */
public interface WorkAllotmentService {
  List<JobDetails> getJobsByWorkerId(Integer userId);
}
