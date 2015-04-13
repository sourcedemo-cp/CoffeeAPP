package com.training.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Integer orderId;
	
	@Column(name="DATE_PAYMENT")
	private Timestamp datePayment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID")
	private Employee employee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TABLE_ID", referencedColumnName="TABLE_ID")
	private CoffeeTable coffeeTable;
	
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY)
	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public CoffeeTable getCoffeeTable() {
		return coffeeTable;
	}

	public void setCoffeeTable(CoffeeTable coffeeTable) {
		this.coffeeTable = coffeeTable;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Timestamp getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Timestamp datePayment) {
		this.datePayment = datePayment;
	}
	
	
}
