package com.citibank.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.citibank.main.domain.Employee;

//read one row from database and convert it into Employee object 
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int employeeId = rs.getInt("employee_id");
		String name = rs.getString("name");
		double salary = rs.getDouble("salary");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setSalary(salary);
		
		return employee;
	}

}
