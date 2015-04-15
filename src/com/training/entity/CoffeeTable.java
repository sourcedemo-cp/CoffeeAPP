package com.training.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tables")
public class CoffeeTable {
	
	@Id
	@GeneratedValue
	@Column(name="TABLE_ID")
	private Integer tableId;
	
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@Column(name="TABLE_QUANTITY")
	private Integer tableQuantity;
	
	@Column(name="TABLE_POSITION")
	private String tablePosition;
	
	@OneToMany(mappedBy="coffeeTable", fetch=FetchType.LAZY)
	private List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getTableQuantity() {
		return tableQuantity;
	}

	public void setTableQuantity(Integer tableQuantity) {
		this.tableQuantity = tableQuantity;
	}

	public String getTablePosition() {
		return tablePosition;
	}

	public void setTablePosition(String tablePosition) {
		this.tablePosition = tablePosition;
	}
	
}
