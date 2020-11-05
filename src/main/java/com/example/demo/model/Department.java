package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "departments")
public class Department {
    @Id
    @Column(name="department_id")
    private Integer departmentId;

    @Column(name="department_name")
    private String departmentName;

    public Department(){}

    public Integer getDepartmentId() {
        return departmentId;
    }
    public String getDepartmentName() { return departmentName; }
}
