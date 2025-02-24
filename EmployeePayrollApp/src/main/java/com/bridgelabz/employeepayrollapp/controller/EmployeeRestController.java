package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Create Employee
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return employeeService.createEmployee(employee);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? "Employee deleted successfully!" : "Employee not found!";
    }
}
