package com.swipejobs.work.controller;

import com.swipejobs.work.model.WorkAllotmentResponse;
import com.swipejobs.work.service.WorkAllotmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api/v1/jobs/")
@RestController
public class WorkAllotmentController {

    private WorkAllotmentService workAllotmentService;

    public WorkAllotmentController(WorkAllotmentService workAllotmentService){
        this.workAllotmentService = workAllotmentService;
    }

@GetMapping("worker/{workerId}")
    public ResponseEntity<List<WorkAllotmentResponse>>getWorksByWorkerId(@PathVariable Integer workerId){
        List<WorkAllotmentResponse> result = workAllotmentService.getJobsByWorkerId(workerId);
        if(result==null)
        {
            return new ResponseEntity<>(new ArrayList<WorkAllotmentResponse>(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result,HttpStatus.OK);


    }
}
