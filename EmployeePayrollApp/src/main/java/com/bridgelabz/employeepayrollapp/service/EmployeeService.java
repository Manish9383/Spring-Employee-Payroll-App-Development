package com.bridgelabz.employeepayrollapp.service;

 import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
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

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeList;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                idCounter++,
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getGender(),
                employeeDTO.getStartDate(),
                employeeDTO.getNote(),
                employeeDTO.getProfilePic(),
                employeeDTO.getDepartments()
        );
        employeeList.add(employee);
        log.info("Employee Created: {}", employee);
        return employee;
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                emp.setGender(employeeDTO.getGender());
                emp.setStartDate(employeeDTO.getStartDate());
                emp.setNote(employeeDTO.getNote());
                emp.setProfilePic(employeeDTO.getProfilePic());
                emp.setDepartments(employeeDTO.getDepartments());

                log.info("Employee Updated: {}", emp);
                return emp;
            }
        }
        log.warn("Employee with ID {} not found for update", id);
        return null;
    }

    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
