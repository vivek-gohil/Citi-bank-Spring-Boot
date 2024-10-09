package com.citibank.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citibank.main.config.SpringConfiguration;
import com.citibank.main.domain.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		// It do not create dependent object
		// Employee employeeObject = new Employee();
		// System.out.println(employeeObject);

		System.out.println("-----------------------------------");
		// Inject Employee Object Using Spring - Dependency Injection
		// 1. Read spring.xml file for bean configuration
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// 2. Inject Employee class object
		Employee employee = applicationContext.getBean("employee", Employee.class);
		System.out.println(employee);
	}

}
