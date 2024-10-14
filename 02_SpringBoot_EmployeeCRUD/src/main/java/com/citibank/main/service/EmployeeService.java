package com.citibank.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.citibank.main.domain.Employee;
import com.citibank.main.exception.EmployeeNotFoundException;
import com.citibank.main.repository.EmployeeRepository;

//Every employee has a address
//EmployeeService has a EmployeeRepository

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> getAllEmployees() {
		LOGGER.info("getAllEmployee() of Service called");
		List<Employee> employeeList = employeeRepository.getAllEmployees();
		return employeeList;
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		LOGGER.info("getEmployeeByEmployeeId() of Service called");
		Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
		if (employee != null)
			return employee;
		else
			throw new EmployeeNotFoundException("No employee found with given employeeId = " + employeeId);
	}

	// Add New Employee
	public boolean addNewEmployee(Employee employee) {
		LOGGER.info("addNewEmployee() of Service called");
		boolean result = employeeRepository.addNewEmployee(employee);
		return result;
	}

	// Update Employee
	public boolean updateEmployee(Employee employee) {
		LOGGER.info("updateEmployee() of Service called");
		boolean result = employeeRepository.updateEmployee(employee);
		return result;
	}

	// Delete Employee
	public boolean deleteEmployee(int employeeId) {
		LOGGER.info("deleteEmployee() of Service called");
		boolean result = employeeRepository.deleteEmployee(employeeId);
		return result;
	}

}
