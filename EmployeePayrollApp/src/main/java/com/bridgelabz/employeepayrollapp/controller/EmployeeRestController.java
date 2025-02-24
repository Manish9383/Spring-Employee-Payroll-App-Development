package com.bridgelabz.employeepayrollapp.controller;

//Use Case : 2
//This is Rest Controller file to ensure that data is transmitted in REST calls


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeRestController {

    private final Map<Long, Map<String, Object>> employees = new HashMap<>();
    private long idCounter = 1; // Auto-increment employee ID

    @GetMapping("/")
    public String getAllEmployees() {
        return employees.isEmpty() ? "No employees found!" : "GET: All employees: " + employees;
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable long id) {
        return employees.containsKey(id) ? "GET: " + employees.get(id) : "Employee not found!";
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Map<String, Object> employee) {
        employees.put(idCounter, employee);
        return "POST: Created employee with ID " + idCounter++;
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody Map<String, Object> employee) {
        if (!employees.containsKey(id)) return "Employee not found!";
        employees.put(id, employee);
        return "PUT: Updated employee with ID " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employees.remove(id) != null ? "DELETE: Employee deleted!" : "Employee not found!";
    }
}
