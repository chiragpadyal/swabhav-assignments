package com.swabhav.models;

public class Product {
	private int productId;
	private String name;
	private String description;
	private Supplier supplier;
	public Product() {};
	public Product(int productId, String name, String description, Supplier supplier) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.supplier = supplier;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", supplier="
				+ supplier + "]";
	}
	
}
