package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "jobs")
public class Job {
    @Id
    @Column(name="job_id")
    private String jobId;

    @Column(name="min_salary")
    private Integer minSalary;

    @Column(name="max_salary")
    private Integer maxSalary;

    public Job(){}

    public String getJobId() {
        return jobId;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }
}
