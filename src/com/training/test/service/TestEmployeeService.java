package com.training.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.entity.Employee;
import com.training.service.EmployeeService;

public class TestEmployeeService {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
		List<Employee> employees = employeeService.getAllEmployee();
		if(null != employees){
			System.out.println("OK");
			System.out.println(employees.size());
		}else {
			System.out.println("Null");
		}
		
		System.out.println(employeeService.isEmployeeByUsernamePassword("cuongn", "123456"));
	}
}
