package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        
        log.info("Payroll App Started in {} Environment", 
                 context.getEnvironment().getProperty("environment"));

        
        log.info("Payroll DB User is {}", 
                 context.getEnvironment().getProperty("spring.datasource.username"));
    }
}
