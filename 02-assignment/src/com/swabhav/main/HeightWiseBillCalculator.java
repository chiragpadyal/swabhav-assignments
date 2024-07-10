package com.swabhav.main;

import java.util.Scanner;

public class HeightWiseBillCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your height (in cm): ");
		int height  = scanner.nextInt();
		int bill = 0;
		if(height > 120) {
			System.out.println("Can ride");
			System.out.println("Enter your age: ");
			int age = scanner.nextInt();
			if (age  < 12) {
				bill  += 5;
			} else if (age >= 12 && age <= 18 ) {
				bill  += 7;
			} else {
				if (age >= 45 && age <= 55 ) {
					bill += 0;
				}else {
					bill += 12;
				}
			};
			System.out.println("Do you want Photos (Yes/No): ");
			boolean wantPhotos = scanner.next().equalsIgnoreCase("yes") ? true : false;
			if(wantPhotos) {
				bill += 3;
			};
			System.out.println("The total bill is $"+ bill);
			
		}else {
			System.out.println("Can't ride");
		}
		scanner.close();
	}
}
