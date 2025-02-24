package com.bridgelabz.employeepayrollapp.model;


//UC3: Introducing Employee model
public class Employee {
 private String name;
 private double salary;

 // Constructor
 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 // Getters and Setters
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public double getSalary() {
     return salary;
 }

 public void setSalary(double salary) {
     this.salary = salary;
 }

 @Override
 public String toString() {
     return "Employee{name='" + name + "', salary=" + salary + "}";
 }
}
