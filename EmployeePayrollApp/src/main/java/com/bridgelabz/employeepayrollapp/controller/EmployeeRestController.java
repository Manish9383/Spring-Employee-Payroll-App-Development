package com.bridgelabz.employeepayrollapp.controller;
/*
Use Case : 13
Add remaining properties to the Payroll DTO and Model Here we add gender, startDate, note, profilePic and department
*/
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j  
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

 // Create Employee
    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Creating employee with Name: {}", employeeDTO.getName());
        Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getSalary(), 
                                         employeeDTO.getGender(), employeeDTO.getStartDate(),
                                         employeeDTO.getNote(), employeeDTO.getProfilePic(),
                                         employeeDTO.getDepartment());
        return employeeService.createEmployee(employee);
    }


    // Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee ID: {}", id);
        Employee updatedEmployee = new Employee(null, employeeDTO.getName(), employeeDTO.getSalary(),
                                                employeeDTO.getGender(), employeeDTO.getStartDate(),
                                                employeeDTO.getNote(), employeeDTO.getProfilePic(),
                                                employeeDTO.getDepartment());
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeByName(employeeDTO.getName());
        if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            emp.setSalary(employeeDTO.getSalary());
            return emp;
        }
        throw new RuntimeException("Employee not found");
    }


    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with ID: {}", id);
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? "Employee deleted successfully!" : "Employee not found!";
    }
}
