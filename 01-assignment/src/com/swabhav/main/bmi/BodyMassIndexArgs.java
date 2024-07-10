package com.swabhav.main.bmi;

public class BodyMassIndexArgs {
	
	double calculateBMI(double weight, double height){
		return weight / (height * height);  
	}
	
	public static void main(String[] args) {
		double weight = Double.parseDouble(args[0]);
		double height = Double.parseDouble(args[1]);
		
		System.out.println("Weight (kg): "+ weight);
		System.out.println("Height (meters): "+ height);
		BodyMassIndexArgs bmiObject = new BodyMassIndexArgs();
		
		double bmi = bmiObject.calculateBMI(weight, height);
		System.out.println("Body Mass Index: "+bmi);
	}
}
