package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.EmployeeDAO;
import com.training.entity.Employee;

public class TestEmployeeDAO {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAOImpl");
		List<Employee> employees = employeeDAO.getAllEmployee();
		if(null != employees) {
			System.out.println("OK");
			System.out.println(employees.size());
		} else {
			System.out.println("null");
		}
		
		Employee employee = employeeDAO.findEmployeeById(1);
		if(null != employee) {
			System.out.println("OK");
		} else {
			System.out.println("null");
		}
		
		// Test check for login
		System.out.println(employeeDAO.isEmployeeByUsernamePassword("cuongn", "123456"));	
	}
	
}
