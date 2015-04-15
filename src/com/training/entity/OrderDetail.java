package com.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue
	@Column(name="ORDERDETAIL_ID")
	private Integer orderDetailId;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")	
	private Product product;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID")
	private Order order;
	

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
