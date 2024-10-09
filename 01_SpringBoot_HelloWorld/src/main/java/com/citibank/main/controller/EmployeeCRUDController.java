package com.citibank.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.main.domain.Employee;

@RestController
@RequestMapping("crudapi")
public class EmployeeCRUDController {

	private List<Employee> employeeList = new ArrayList();

	public EmployeeCRUDController() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId(101);
		employee1.setName("Test 1");
		employee1.setSalary(1000);

		Employee employee2 = new Employee();
		employee2.setEmployeeId(102);
		employee2.setName("Test 2");
		employee2.setSalary(1000);

		employeeList.add(employee1);
		employeeList.add(employee2);
	}

	//http://localhost:8080/crudapi/employee
	@GetMapping("employee")
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}
