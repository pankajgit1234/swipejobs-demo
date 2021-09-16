package com.swipejobs.work.service;

import com.swipejobs.work.model.Job;
import com.swipejobs.work.model.JobDetails;
import com.swipejobs.work.model.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Work allotment service implementation.
 */
@Service
public class WorkAllotmentServiceImpl implements WorkAllotmentService {

    @Value("${api.suitable.job.count}")
    private int jobCount ;

    private WorkAllotmentEndPointsApi workAllotmentEndPointsApi;

    WorkAllotmentServiceImpl(WorkAllotmentEndPointsApi workAllotmentEndPointsApi) {
        this.workAllotmentEndPointsApi = workAllotmentEndPointsApi;
    }


    @Override
    public List<JobDetails> getJobsByWorkerId(Integer userId) {
        List<Worker> workers = workAllotmentEndPointsApi.getAllWorkers();
        List<Job> jobs = workAllotmentEndPointsApi.getAllJobs();
        Optional<Worker> optionalWorker = workers.stream()
                .filter(workerElement -> workerElement.getUserId() == userId)
                .findAny();

        if (optionalWorker.isPresent()) {
            return getSuitableJobs(optionalWorker.get(), jobs);
        }

        // No worker found for the provided user id.
        return new ArrayList<>();
    }

    private List<JobDetails> getSuitableJobs(Worker worker, List<Job> jobs) {
        double workerLat = Double.parseDouble(worker.getJobSearchAddress().getLatitude());
        double workerLong = Double.parseDouble(worker.getJobSearchAddress().getLongitude());

        List<Job> suitableJobs = jobs.stream()
                .filter(job -> job.getWorkersRequired() > 0
                        && job.isDriverLicenseRequired() == worker.isHasDriversLicense()
                        && !Collections.disjoint(job.getRequiredCertificates(),worker.getCertificates())
                        && isCompanyInRangeForWorker(workerLat, workerLong,
                        Double.parseDouble(job.getLocation().getLatitude()),
                        Double.parseDouble(job.getLocation().getLongitude()),
                        worker.getJobSearchAddress().getMaxJobDistance())
                )
                .limit(jobCount)
                .collect(Collectors.toList());

        return suitableJobs.stream().map(job ->
                new JobDetails(
                        job.getJobId(),
                        job.getCompany(),
                        job.getJobTitle(),
                        job.getAbout()
                )
        ).collect(Collectors.toList());
    }

    /* Calculates the workers priority to work according to distance. */
    boolean isCompanyInRangeForWorker(double workerLat, double workerLong, double compLat, double compLong, int range) {
        boolean result = false;
        if ((workerLat == compLat) && (workerLong == compLong)) {
            result = true;
        } else {
            double theta = workerLong - compLong;
            double dist = Math.sin(Math.toRadians(workerLat)) * Math.sin(Math.toRadians(compLat)) + Math.cos(Math.toRadians(workerLat)) * Math.cos(Math.toRadians(compLat)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            if ((double) range >= dist) {
                result = true;
            }
        }
        return result;
    }
}
