package com.swipejobs.work.model;

import java.io.Serializable;

/**
 * Job details for a worker.
 */
public final class JobDetails implements Serializable {
    private Integer jobId;
    private String company;
    private String jobTitle;
    private String jobDescription;

    public JobDetails() {
    }

    public JobDetails(Integer jobId, String company, String jobTitle, String jobDescription) {
        this.jobId = jobId;
        this.company = company;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
