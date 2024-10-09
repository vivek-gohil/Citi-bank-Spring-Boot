package com.citibank.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// http://localhost:8080/crudapi/employee - HTTP Method = Get
	@GetMapping("employee")
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	// http://localhost:8080/crudapi/employee/{employeeId} - HTTP Method = Get
	@GetMapping("employee/{employeeId}")
	public Employee getEmployeeByEmployeeId(@PathVariable int employeeId) {
		for (Employee e : employeeList) {
			if (e.getEmployeeId() == employeeId) {
				return e;
			}
		}
		return null;
	}

	// http://localhost:8080/crudapi/employee - HTTP Method = Post
	@PostMapping("employee")
	public boolean addNewEmployee(@RequestBody Employee employee) {
		boolean result;
		result = employeeList.add(employee);
		return result;
	}

	// http://localhost:8080/crudapi/employee/{employeeId} - HTTP Method = Delete
	@DeleteMapping("employee/{employeeId}")
	public boolean deleteEmployeeByEmployeeId(@PathVariable int employeeId) {
		for(Employee e : employeeList) {
			if(e.getEmployeeId() == employeeId) {
				employeeList.remove(e);
				return true;
			}
		}
		return false;
	}
}
