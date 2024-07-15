package com.swabhav.model;

public class Employee {
	private int employeeId;
	private double salary;
	private String name;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		if(employeeId >= 0)
		this.employeeId = employeeId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary >= 0)
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() > 1)
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee ID: " + this.employeeId + " | Employee Name: " + this.name + " | Salary: Rs. " + this.salary;
	}
	
	
}
