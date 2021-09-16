package com.swipejobs.work.service;

import com.swipejobs.work.model.Job;
import com.swipejobs.work.model.WorkAllotmentResponse;
import com.swipejobs.work.model.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkAllotmentServiceImpl implements WorkAllotmentService {

    @Value("${api.suitable.job.count}")
    private int jobCount;

    private ServiceHardening serviceHardening;


    private WorkAllotmentServiceImpl(ServiceHardening serviceHardening) {
        this.serviceHardening = serviceHardening;
    }


    @Override
    public List<WorkAllotmentResponse> getJobsByWorkerId(Integer userId) {
        List<Worker> workers = serviceHardening.getAllWorkers();
        List<Job> jobs = serviceHardening.getAllJobs();
        Worker worker = workers.stream()
                .filter(x -> x.getUserId() == userId)
                .findAny()
                .orElse(null);
        if (worker == null) {
            return null;
        }


        return getSuitableJobs(worker, jobs);
    }

    private List<WorkAllotmentResponse> getSuitableJobs(Worker worker, List<Job> jobs) {
        String workerLocationLatitude = worker.getJobSearchAddress().getLatitude();
        String workerLocationLongitude = worker.getJobSearchAddress().getLongitude();
        double workerLat = Double.parseDouble(workerLocationLatitude);
        double workerLong = Double.parseDouble(workerLocationLongitude);
        List<WorkAllotmentResponse> result = new ArrayList<>();

        List<Job> suitableJobs = jobs.stream()
                .filter(x -> x.getWorkersRequired() > 0
                        && x.isDriverLicenseRequired() == worker.isHasDriversLicense()
                        && x.getRequiredCertificates().stream().filter(worker.getCertificates()::contains)
                        .collect(Collectors.toList()).size() > 0
                        && isCompanyInRangeForWorker(workerLat, workerLong, Double.parseDouble(x.getLocation().getLatitude()),
                        Double.parseDouble(x.getLocation().getLongitude()), worker.getJobSearchAddress().getMaxJobDistance())
                )
                .limit(jobCount)
                .collect(Collectors.toList());

        suitableJobs.stream()
                .forEach(x -> {
                    WorkAllotmentResponse workAllotmentResponse = new WorkAllotmentResponse();
                    workAllotmentResponse.setCompany(x.getCompany());
                    workAllotmentResponse.setJobId(x.getJobId());
                    workAllotmentResponse.setJobTitle(x.getJobTitle());
                    workAllotmentResponse.setJobDescription(x.getAbout());
                    result.add(workAllotmentResponse);
                });


        return result;
    }

    private boolean isCompanyInRangeForWorker(double workerLat, double workerLong, double compLat, double compLong, int range) {
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
