package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
//UC6 used lombok
@Data  
@NoArgsConstructor  
@AllArgsConstructor  
public class EmployeeDTO {
    private String name;
    private double salary;
}
