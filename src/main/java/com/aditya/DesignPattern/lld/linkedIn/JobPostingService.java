package com.aditya.DesignPattern.lld.linkedIn;

import java.util.HashMap;
import java.util.Map;

public class JobPostingService {

    private Map<String, JobPosting> jobPostingMap;

    public JobPostingService() {
        jobPostingMap = new HashMap<>();
    }

    public void addJobPosting(JobPosting jobPosting) {
        this.jobPostingMap.put(jobPosting.getJobId(), jobPosting);
    }

    public JobPosting getJobPostingById(String jobId) {
        return jobPostingMap.get(jobId);
    }
}
