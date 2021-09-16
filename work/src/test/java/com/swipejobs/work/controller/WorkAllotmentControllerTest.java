package com.swipejobs.work.controller;

import com.swipejobs.work.model.JobDetails;
import com.swipejobs.work.service.WorkAllotmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test case for {@link WorkAllotmentController}
 */
public class WorkAllotmentControllerTest {
  @InjectMocks
  private WorkAllotmentController mockWorkAllotmentController;
  @Mock
  WorkAllotmentService mockWorkAllotmentService;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(mockWorkAllotmentController).build();
  }

  @Test
  public void getWorkersList() throws Exception {
    when(mockWorkAllotmentService.getJobsByWorkerId(any())).thenReturn(List.of(new JobDetails()));

    this.mockMvc.perform(get("/api/v1/worker/jobs/0")).andExpect(status().isOk());
  }
}
