package com.swipejobs.work.model;

import java.util.List;

public class Worker {
    private Integer rating;
    private Integer userId;
    private String guid;
    private Integer age;
    private Name name;
    private String email;
    private String phone;
    private List<DayAvailability> availability;
    private boolean hasDriversLicense;
    private String transportation;
    private JobSearchAddress jobSearchAddress;
    private List<String>skills;
    private List<String>certificates;
    private boolean isActive;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<DayAvailability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<DayAvailability> availability) {
        this.availability = availability;
    }

    public boolean isHasDriversLicense() {
        return hasDriversLicense;
    }

    public void setHasDriversLicense(boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
