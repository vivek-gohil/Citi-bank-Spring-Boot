package com.citibank.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.main.domain.Employee;
import com.citibank.main.dto.ResponseDto;
import com.citibank.main.service.EmployeeService;

//EmployeeCRUDControllerV2 has a EmployeeService
@RestController
@RequestMapping("crudapi/v2")
public class EmployeeCRUDControllerV2 {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("employee")
	public ResponseEntity<List<Employee>> showAllEmployee() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}

	@GetMapping("employee/{employeeId}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	// Create endpoint for Add new employee
	@PostMapping("employee")
	public ResponseEntity<ResponseDto> addNewEmployee(@RequestBody Employee employee) {
		boolean result = employeeService.addNewEmployee(employee);
		ResponseDto responseDto = new ResponseDto();
		if (result) {
			responseDto.setStatusCode("201");
			responseDto.setStatusMessage("New employee created successfully");
		} else {
			responseDto.setStatusCode("500");
			responseDto.setStatusMessage("Failed To add new employee");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}

	// Create endpoint for Update employee
	// http://localhost:8080/crudapi/employee - HTTP Method = Put
	@PutMapping("employee")
	public boolean updateEmployee(@RequestBody Employee employee) {
		boolean result = employeeService.updateEmployee(employee);
		return result;
	}

	// Create endpoint for Delete employee
	// http://localhost:8080/crudapi/employee/{employeeId} - HTTP Method = Delete
	@DeleteMapping("employee/{employeeId}")
	public boolean deleteEmployeeByEmployeeId(@PathVariable int employeeId) {
		boolean result = employeeService.deleteEmployee(employeeId);
		return result;
	}

}
