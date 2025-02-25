package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by Name
    public Optional<Employee> getEmployeeByName(String name) {
        return employeeList.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .findFirst();
    }


    // Create Employee
    public Employee createEmployee(Employee employee) {
        employee.setId((long) (employeeList.size() + 1)); // Auto-increment ID
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
