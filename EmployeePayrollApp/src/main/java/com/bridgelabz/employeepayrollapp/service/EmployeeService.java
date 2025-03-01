package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j  
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long idCounter = 1L; 

    // Get all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }


    // Get employee by Name
    public Optional<Employee> getEmployeeByName(String name) {

        return employeeList.stream()
                .filter(emp -> emp.getName().equals(name))
                .findFirst();
    }



    // Create Employee
    public Employee createEmployee(Employee employee) {
        employee.setId(idCounter++); // Auto-increment ID
        employeeList.add(employee);
        log.info("Employee Created: {}", employee);
        return employee;
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(updatedEmployee.getName());
                emp.setSalary(updatedEmployee.getSalary());
                emp.setGender(updatedEmployee.getGender());
                emp.setStartDate(updatedEmployee.getStartDate());
                emp.setNote(updatedEmployee.getNote());
                emp.setProfilePic(updatedEmployee.getProfilePic());
                emp.setDepartment(updatedEmployee.getDepartment());
                log.info("Employee Updated: {}", emp);
                return emp;
            }
        }
        log.warn("Employee with ID {} not found for update", id);
        return null;
    }


    // Delete Employee
    public boolean deleteEmployee(Long id) {
        boolean isDeleted = employeeList.removeIf(emp -> emp.getId().equals(id));
        if (isDeleted) {
            log.info("Employee with ID {} deleted successfully", id);
        } else {
            log.warn("Employee with ID {} not found for deletion", id);
        }
        return isDeleted;
    }
}
