package com.swabhav.models;

import java.sql.Date;

public class Order {
	private int orderId;
	private Date orderDate;
	private Supplier supplier;
	public Order(int orderId, Date orderDate, Supplier supplier) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.supplier = supplier;
	}
	public Order() {};
	public int getOrderId() {
		return orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", supplier=" + supplier + "]";
	}
	
	
	
}
