package com.bridgelabz.employeepayrollapp.controller;

//Use Case : 2
//This is Rest Controller file to ensure that data is transmitted in REST calls


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeRestController {

    @GetMapping("/")
    public String getAllEmployees() {
        return "Getting all employees!";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable("id") Long id) {
        return "Getting employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employee) {
        return "Employee created: " + employee;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employee) {
        return "Employee updated with details: " + employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return "Employee with ID " + id + " deleted.";
    }
}