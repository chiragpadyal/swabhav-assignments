package com.swabhav.main.bmi;

import java.util.Scanner;

public class BodyMassIndex {
	
	double calculateBMI(double weight, double height){
		return weight / (height * height);  
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter weight in kilogram:");
		double weight = scanner.nextDouble();
		System.out.println("Enter height in meters:");
		double height = scanner.nextDouble();
		
		System.out.println("Weight (kg): "+ weight);
		System.out.println("Height (meters): "+ height);
		BodyMassIndex bmiObject = new BodyMassIndex();
		
		double bmi = bmiObject.calculateBMI(weight, height);
		System.out.println("Body Mass Index: "+bmi);
		
		scanner.close();
	}
}
