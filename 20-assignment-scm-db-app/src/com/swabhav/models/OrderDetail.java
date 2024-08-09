package com.swabhav.models;


public class OrderDetail {
	private int orderDetailId;
	private Order order;
	private Product product;
	private int quantity;
	private double price;
	public OrderDetail() {};
	public OrderDetail(int orderDetailId, Order order, Product product, int quantity, double price) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public Order getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
