package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeRestController {

    @Autowired  // UC4: Injecting EmployeeService
    private EmployeeService employeeService;

    // UC2: Gett all employees
    @GetMapping("/")
    public String getAllEmployees() {
        return "Getting all employees!";
    }

    // UC2: Get employee by ID
    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable("id") Long id) {
        return "Getting employee with ID: " + id;
    }

    // UC4: Now using service layer to create employee
    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.createEmployee(employeeDTO);
        return "Employee created: " + employee;
    }

    // UC4: Now using service layer to update employee
    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.updateEmployee(employeeDTO);
        return "Employee updated with details: " + employee;
    }

    // UC2: Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return "Employee with ID " + id + " deleted.";
    }
}
