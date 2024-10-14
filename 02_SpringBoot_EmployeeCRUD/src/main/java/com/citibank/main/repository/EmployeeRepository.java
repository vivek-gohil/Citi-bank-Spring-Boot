package com.citibank.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citibank.main.domain.Employee;

//Database 
@Repository
public class EmployeeRepository {

	private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee_details";
	private static final String SELECT_ONE_EMPLOYEE = "SELECT * FROM employee_details WHERE employee_id=?";
	private static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employee_details(name,salary) VALUES(?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?,salary=? WHERE employee_id=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Add Employee Into List
	public boolean addNewEmployee(Employee employee) {
		Object[] params = { employee.getName(), employee.getSalary() };

		int rowCount = jdbcTemplate.update(INSERT_NEW_EMPLOYEE, params);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	// Get All Employees
	public List<Employee> getAllEmployees() {

		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> employeeList = jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeeRowMapper);
		return employeeList;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);

	// Execute Query
	// Get One Employee
	public Employee getEmployeeByEmployeeId(int employeeId) {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		try {
			Employee employee = jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, employeeRowMapper, employeeId);
			return employee;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Invalid employeeId :: " + employeeId);
			return null;
		}
	}

	// Delete Employee By EmployeeId
	public boolean deleteEmployee(int employeeId) {
		int rowCount = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	// Update Employee
	public boolean updateEmployee(Employee employee) {
		Object[] params = { employee.getName(), employee.getSalary(), employee.getEmployeeId() };
		int rowCount = jdbcTemplate.update(UPDATE_EMPLOYEE, params);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

}
