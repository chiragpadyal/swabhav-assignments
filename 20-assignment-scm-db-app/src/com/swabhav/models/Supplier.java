package com.swabhav.models;

import java.util.List;
import java.util.stream.Collectors;

public class Supplier {
	private int supplierId;
	private String name;
	private String contactInfo;
	private String address;
	public Supplier() {};
	public Supplier(int supplierId, String name, String contactInfo, String address) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.address = address;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public String getName() {
		return name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name + ", contactInfo=" + contactInfo + ", address="
				+ address + "]";
	}
	

	
	
	
}
