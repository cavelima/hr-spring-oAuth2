package com.example.demo.response;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Job;

import java.util.ArrayList;
import java.util.List;

public class EmployeeJobHistory {
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private List<String> departmentName;
    private List<Integer> minSalary;
    private List<Integer> maxSalary;
    private Long currentSalary;

    public EmployeeJobHistory(Employee e, List<Job> jobs, List<Department> departments)
    {
        this.employeeId = e.getEmployeeId();
        this.employeeFirstName = e.getFirstName();
        this.employeeLastName = e.getLastName();
        this.currentSalary = e.getSalary();

        this.minSalary = new ArrayList<>();
        this.maxSalary = new ArrayList<>();
        for (Job job : jobs) {
            this.minSalary.add(job.getMinSalary());
            this.maxSalary.add(job.getMaxSalary());
        }

        this.departmentName = new ArrayList<>();
        for (Department department : departments) {
            this.departmentName.add(department.getDepartmentName());
        }
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public List<String> getDepartmentName() {
        return departmentName;
    }

    public List<Integer> getMinSalary() {
        return minSalary;
    }

    public List<Integer> getMaxSalary() {
        return maxSalary;
    }

    public Long getCurrentSalary() {
        return currentSalary;
    }
}
