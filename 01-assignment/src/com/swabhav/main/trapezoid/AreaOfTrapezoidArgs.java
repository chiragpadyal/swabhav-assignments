package com.swabhav.main.trapezoid;

public class AreaOfTrapezoidArgs {
	double calculateAreaOfTrapezoid(double height, double base1 , double base2) {
	    return ((base1 + base2) / 2) * height; 
	}
	
	public static void main(String[] args) {
		double height = Double.parseDouble(args[0]);
		double base1 = Double.parseDouble(args[1]);
		double base2 = Double.parseDouble(args[2]);
		
		System.out.println("Heigt Of Trapezoid (m): "+ height);
		System.out.println("Base 1 Of Trapezoid: (m)"+ base1);
		System.out.println("Base 2 Of Trapezoid: (m)"+ base2);
		
		AreaOfTrapezoidArgs areaOfTrapezoidObject = new AreaOfTrapezoidArgs();
		double areaOfTrapezoid = areaOfTrapezoidObject.calculateAreaOfTrapezoid(height, base1, base2);
		System.out.println("Area Of Trapezoid is " + areaOfTrapezoid);
	}
}
