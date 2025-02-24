package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeRestController {

    // UC2: Get all employees
    @GetMapping("/")
    public String getAllEmployees() {
        return "Getting all employees!";
    }

    // UC2: Get employee by ID
    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable("id") Long id) {
        return "Getting employee with ID: " + id;
    }

    // UC3: Create Employee using DTO instead of raw String
    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return "Employee created: " + employee;
    }

    // UC3: Update Employee using DTO instead of raw String
    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return "Employee updated with details: " + employee;
    }

    // UC2: Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return "Employee with ID " + id + " deleted.";
    }
}
