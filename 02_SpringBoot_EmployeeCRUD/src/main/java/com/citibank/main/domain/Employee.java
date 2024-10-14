package com.citibank.main.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class Employee {
	private int employeeId;

	@NotEmpty(message = "Employee name cannot be null or empty")
	private String name;

	@Min(value = 10000, message = "Salary > 10000")
	private double salary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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

}
