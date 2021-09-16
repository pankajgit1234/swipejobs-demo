package com.swipejobs.work.service;

import com.swipejobs.work.model.WorkAllotmentResponse;

import java.util.List;

public interface WorkAllotmentService {

    List<WorkAllotmentResponse> getJobsByWorkerId(Integer userId);

}
