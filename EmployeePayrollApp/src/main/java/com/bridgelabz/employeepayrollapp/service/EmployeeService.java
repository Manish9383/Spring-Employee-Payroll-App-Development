package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

@Service  // UC4: Service Layer
public class EmployeeService {

    // UC4: Creating Employee from DTO
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getName(), employeeDTO.getSalary());
    }

    // UC4: Updating Employee from DTO
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getName(), employeeDTO.getSalary());
    }
}
