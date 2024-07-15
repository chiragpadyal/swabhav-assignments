package com.swabhav.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.swabhav.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many employee to create");
		int amountOfEmployee = scanner.nextInt();
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		for (int i = 1; i <= amountOfEmployee; i++) {
			Employee employee = new Employee();
			System.out.println("Enter employee " + i + " id: ");
			employee.setEmployeeId(scanner.nextInt());
			System.out.println("Enter employee " + i + " name: ");
			employee.setName(scanner.next());
			System.out.println("Enter employee " + i + " salary: ");
			employee.setSalary(scanner.nextDouble());
			
			employeeList.add(employee);
		}
		
		for (Employee employee : employeeList) {
			System.out.println(employee.toString());
		}
		
		
		scanner.close();
	}
}
