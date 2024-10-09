package com.citibank.main.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Every employee has a address - Dependency 
@Component
public class Employee {
	private int employeeId;
	private String name;
	private double salary;

	@Autowired
	private Address homeAddress;

	// Constructor
	private Employee() {

	}

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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", homeAddress="
				+ homeAddress + "]";
	}

}
