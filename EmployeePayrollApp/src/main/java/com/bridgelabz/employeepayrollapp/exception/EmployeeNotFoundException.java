package com.bridgelabz.employeepayrollapp.exception;


public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(long id){
        super("Employee with ID " + id + " not found.");
    }
}