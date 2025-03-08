package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ✅ Get all employees from MySQL DB
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeRepository.findAll();
    }

    // ✅ Find employee by ID (throws exception if not found)
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // ✅ Create new employee with departments handling
    @Transactional
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());

        // Save employee first to generate an ID
        Employee savedEmployee = employeeRepository.save(employee);
        
        // Now set departments after the employee has been saved
        savedEmployee.setDepartments(employeeDTO.getDepartments());
        
        log.info("Saving new employee: {}", savedEmployee);
        return employeeRepository.save(savedEmployee);
    }

    // ✅ Update employee (throws exception if not found)
    @Transactional
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartments(employeeDTO.getDepartments());

        log.info("Updating employee: {}", employee);
        return employeeRepository.save(employee);
    }

    // ✅ Delete employee (throws exception if not found)
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
        log.info("Deleted employee with ID: {}", id);
    }
}
