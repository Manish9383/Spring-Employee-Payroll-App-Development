package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("Creating employee: {}", employeeDTO);
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee ID {} with data: {}", id, employeeDTO);
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}
