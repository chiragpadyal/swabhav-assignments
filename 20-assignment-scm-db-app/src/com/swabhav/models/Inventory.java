package com.swabhav.models;

public class Inventory {
	private int inventoryId;
	private Product product;
	private int quatityOnHand;
	
	public Inventory() {};
	
	public int getInventoryId() {
		return inventoryId;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuatityOnHand() {
		return quatityOnHand;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setQuatityOnHand(int quatityOnHand) {
		this.quatityOnHand = quatityOnHand;
	}
	public Inventory(int inventoryId, Product product, int quatityOnHand) {
		super();
		this.inventoryId = inventoryId;
		this.product = product;
		this.quatityOnHand = quatityOnHand;
	}
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", product=" + product + ", quatityOnHand=" + quatityOnHand
				+ "]";
	}

	
	
	
}
