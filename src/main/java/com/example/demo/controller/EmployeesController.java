package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Job;
import com.example.demo.model.JobHistory;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.JobHistoryRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.response.EmployeeJobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/employees/")
public class EmployeesController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JobHistoryRepository jobHistoryRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value="/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @CrossOrigin(allowCredentials = "true")
    @GetMapping(value="/{id}")
    public EmployeeJobHistory getByEmployeeId(@PathVariable("id") Integer employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        List<JobHistory> jobHistory = jobHistoryRepository.findAllByEmployeeId(employeeId);
        List<Job> jobs = new ArrayList<Job>();
        List<Department> departments = new ArrayList<Department>();
        departments.add(departmentRepository.findByDepartmentId(employee.getDepartmentId()));
        jobs.add(jobRepository.findByJobId(employee.getJobId()));
        for (JobHistory job : jobHistory) {
            jobs.add(jobRepository.findByJobId(job.getJobId()));
            departments.add(departmentRepository.findByDepartmentId(job.getDepartmentId()));
        }

        return new EmployeeJobHistory(employee, jobs, departments);
    }

    @CrossOrigin
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            path="/add")
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @CrossOrigin
    @PutMapping(path = "/update/{id}")
    ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer employeeId) {
        Optional<Employee> e = this.employeeRepository.findById(employeeId);
        if (!e.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete/{id}")
    void deleteEmployee(@PathVariable("id") Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
