package com.swabhav.main.trapezoid;

import java.util.Scanner;

public class AreaOfTrapezoid {
	double calculateAreaOfTrapezoid(double height, double base1 , double base2) {
	    return ((base1 + base2) / 2) * height; 
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter height of trapezoid in (m):");
		double height = scanner.nextDouble();
		System.out.println("Enter base 1 of trapezoid in (m):");
		double base1 = scanner.nextDouble();
		System.out.println("Enter base 2 of trapezoid in (m):");
		double base2 = scanner.nextDouble();
		
		System.out.println("Heigt Of Trapezoid (m): "+ height);
		System.out.println("Base 1 Of Trapezoid: (m)"+ base1);
		System.out.println("Base 2 Of Trapezoid: (m)"+ base2);
		
		AreaOfTrapezoid areaOfTrapezoidObject = new AreaOfTrapezoid();
		double areaOfTrapezoid = areaOfTrapezoidObject.calculateAreaOfTrapezoid(height, base1, base2);
		System.out.println("Area Of Trapezoid is " + areaOfTrapezoid);
		scanner.close();
	}
}
