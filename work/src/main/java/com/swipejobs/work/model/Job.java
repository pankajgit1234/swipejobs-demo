package com.swipejobs.work.model;

import java.util.List;

public class Job {

    private Integer jobId;
    private String guid;
    private String company;
    private String jobTitle;
    private String about;
    private String startDate;
    private Integer workersRequired;
    private String billRate;
    private Location location;
    private List<String> requiredCertificates;
    private boolean driverLicenseRequired;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getWorkersRequired() {
        return workersRequired;
    }

    public void setWorkersRequired(Integer workersRequired) {
        this.workersRequired = workersRequired;
    }

    public String getBillRate() {
        return billRate;
    }

    public void setBillRate(String billRate) {
        this.billRate = billRate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getRequiredCertificates() {
        return requiredCertificates;
    }

    public void setRequiredCertificates(List<String> requiredCertificates) {
        this.requiredCertificates = requiredCertificates;
    }

    public boolean isDriverLicenseRequired() {
        return driverLicenseRequired;
    }

    public void setDriverLicenseRequired(boolean driverLicenseRequired) {
        this.driverLicenseRequired = driverLicenseRequired;
    }
}
