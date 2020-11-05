package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="job_history")
public class JobHistory {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;

    @Column(name="job_id")
    private String jobId;

    @Column(name="department_id")
    private Integer departmentId;

    public JobHistory(){}

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getJobId() {
        return jobId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }
}
