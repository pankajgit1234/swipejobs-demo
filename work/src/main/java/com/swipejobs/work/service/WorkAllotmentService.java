package com.swipejobs.work.service;

import com.swipejobs.work.model.JobDetails;

import java.util.List;

public interface WorkAllotmentService {

    List<JobDetails> getJobsByWorkerId(Integer userId);

}
