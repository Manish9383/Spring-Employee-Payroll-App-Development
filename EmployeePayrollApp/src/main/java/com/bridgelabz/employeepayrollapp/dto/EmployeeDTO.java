package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name is required and cannot be empty.")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must contain only letters and spaces (3-50 characters).")
    private String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    private double salary;

    @NotBlank(message = "Gender is required")
    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    private List<String> department; // List of department names
}
