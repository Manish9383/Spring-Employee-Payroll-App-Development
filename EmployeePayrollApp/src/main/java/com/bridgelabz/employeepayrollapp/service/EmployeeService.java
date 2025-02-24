package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long idCounter = 1L; // ID counter

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }

    // Create Employee
    public Employee createEmployee(Employee employee) {
        employee.setId(idCounter++); // Auto-increment ID
        employeeList.add(employee);
        return employee;
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(updatedEmployee.getName());
                emp.setSalary(updatedEmployee.getSalary());
                return emp;
            }
        }
        return null;
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
