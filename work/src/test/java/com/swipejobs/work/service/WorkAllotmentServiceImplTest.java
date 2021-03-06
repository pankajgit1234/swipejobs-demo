package com.swipejobs.work.service;

import com.swipejobs.work.model.Job;
import com.swipejobs.work.model.JobDetails;
import com.swipejobs.work.model.Worker;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test case for {@link WorkAllotmentServiceImpl}
 */
public final class WorkAllotmentServiceImplTest {

  @Mock
  WorkAllotmentEndPointsApi mockWorkAllotmentEndPointsApi;
  private WorkAllotmentServiceImpl workAllotmentService = null;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    workAllotmentService = new WorkAllotmentServiceImpl(mockWorkAllotmentEndPointsApi);
  }

  @Test
  public void getJobsByWorkerId() {
    when(mockWorkAllotmentEndPointsApi.getAllWorkers()).thenReturn(getWorkers());
    when(mockWorkAllotmentEndPointsApi.getAllJobs()).thenReturn(getJobs());

    List<JobDetails> workAllotmentResponse =
        workAllotmentService.getJobsByWorkerId(1);

    assertEquals(3, workAllotmentResponse.size());
    // Asserting only the job ids.
    assertEquals(Arrays.asList(3, 4, 5), workAllotmentResponse.stream().map(JobDetails::getJobId).collect(Collectors.toList()));
  }

  private List<Worker> getWorkers() {
    Worker worker1 = new Worker();
    Worker worker2 = new Worker();
    // Has driving licence and certificates.
    worker1.setUserId(1);
    worker1.setHasDriversLicense(true);
    worker1.setCertificates(Arrays.asList(
        "C", "CC",
        "D", "DD",
        "E", "EE"
    ));
    // Has driving licence but no certificates are there.
    worker2.setUserId(2);
    worker2.setHasDriversLicense(true);
    return Arrays.asList(worker1, worker2);
  }

  private List<Job> getJobs() {
    Job job1 = new Job();
    job1.setJobId(1);
    job1.setWorkersRequired(2);
    job1.setDriverLicenseRequired(true);
    job1.setRequiredCertificates(Arrays.asList("A", "AA"));
    Job job2 = new Job();
    job2.setJobId(2);
    job2.setWorkersRequired(2);
    job2.setDriverLicenseRequired(false);
    job2.setRequiredCertificates(Arrays.asList("B", "BB"));
    Job job3 = new Job();
    job3.setJobId(3);
    job3.setWorkersRequired(2);
    job3.setDriverLicenseRequired(true);
    job3.setRequiredCertificates(Arrays.asList("C", "CC"));
    Job job4 = new Job();
    job4.setJobId(4);
    job4.setWorkersRequired(2);
    job4.setDriverLicenseRequired(true);
    job4.setRequiredCertificates(Arrays.asList("D", "DD"));
    Job job5 = new Job();
    job5.setJobId(5);
    job5.setWorkersRequired(2);
    job5.setDriverLicenseRequired(true);
    job5.setRequiredCertificates(Arrays.asList("E", "EE"));

    return Arrays.asList(job1, job2, job3, job4, job5);
  }
}
