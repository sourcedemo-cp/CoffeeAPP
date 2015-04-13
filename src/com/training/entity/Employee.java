package com.training.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="EMPLOYEE_CITY")
	private String empoyeeCity;
	
	@Column(name="EMPLOYEE_ADDRESS")
	private String employeeAddress;
	
	@Column(name="EMPLOYEE_TELEPHONE")
	private String employeeTelephone;
	
	@Column(name="SHIFT")
	private String shift;
	
	@Column(name="WORK_DATE")
	private String workDate;
	
	@Column(name="EMPLOYEE_SEX")
	private String employeeSex;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="PASSWORD")
	private String password;

	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	private List<Order> orders;
	
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpoyeeCity() {
		return empoyeeCity;
	}

	public void setEmpoyeeCity(String empoyeeCity) {
		this.empoyeeCity = empoyeeCity;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
