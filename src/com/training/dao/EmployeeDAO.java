package com.training.dao;

import java.util.List;

import com.training.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	public int addEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public Employee findEmployeeById(int id);
	public boolean isEmployeeByUsernamePassword(String userName, String passWord);
	public boolean deleteEmployeeById(Employee employee);
	
}
