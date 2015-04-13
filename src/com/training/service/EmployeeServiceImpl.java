package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.EmployeeDAO;
import com.training.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public int addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployeeById(Employee employee) {
		return employeeDAO.deleteEmployeeById(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(int id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	public boolean isEmployeeByUsernamePassword(String userName, String passWord) {
		return employeeDAO.isEmployeeByUsernamePassword(userName, passWord);
	}

}
