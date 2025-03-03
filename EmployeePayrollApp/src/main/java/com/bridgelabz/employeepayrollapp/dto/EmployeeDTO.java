package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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

    @Pattern(regexp = "Male|Female|Other", message = "Gender must be male, female, or other.")    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "Start date should be a past or present date.")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty.")
    private String note;

    @NotBlank(message = "Profile picture URL cannot be empty.")
    private String profilePic;

    @NotEmpty(message = "Department list cannot be empty.")
    private List<String> departments;
}