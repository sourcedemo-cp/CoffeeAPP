package com.training.service;

import java.util.List;

import com.training.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public int addEmployee(Employee employee);
	public boolean deleteEmployeeById(Employee employee);
	public int updateEmployee(Employee employee);
	public Employee findEmployeeById(int id);
	public boolean isEmployeeByUsernamePassword(String userName, String passWord);
	
}
