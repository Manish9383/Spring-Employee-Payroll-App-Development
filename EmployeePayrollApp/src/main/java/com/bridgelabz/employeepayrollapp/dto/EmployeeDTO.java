package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  
@NoArgsConstructor  
@AllArgsConstructor  
public class EmployeeDTO {
    private String name;
    private double salary;
}
