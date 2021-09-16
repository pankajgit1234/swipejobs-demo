package com.swipejobs.work.controller;

import com.swipejobs.work.model.JobDetails;
import com.swipejobs.work.service.WorkAllotmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller to fetch the suitable jobs for a worker.
 */
@RequestMapping("/api/v1/jobs/")
@RestController
public class WorkAllotmentController {

    private WorkAllotmentService workAllotmentService;

    WorkAllotmentController(WorkAllotmentService workAllotmentService) {
        this.workAllotmentService = workAllotmentService;
    }

    @GetMapping("worker/{workerId}")
    public ResponseEntity<List<JobDetails>> getWorksByWorkerId(@PathVariable Integer workerId) {
        List<JobDetails> jobs = workAllotmentService.getJobsByWorkerId(workerId);
        if(jobs==null)
        {
            return new ResponseEntity<>(new ArrayList<JobDetails>(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}
