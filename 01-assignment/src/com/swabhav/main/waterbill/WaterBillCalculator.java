package com.swabhav.main.waterbill;

import java.util.Scanner;

public class WaterBillCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter units: ");
		int units_consumed = scanner.nextInt();
		final int METER_CHARGE = 75;
		int charge = 0;
		int total_water_bill = 0;
		if(units_consumed <= 100) {
			charge = units_consumed * 5;
		}else {
			if(units_consumed <= 250) {
				charge = units_consumed * 10;
			}else {
				charge = units_consumed * 20;
			}
		}
		
		total_water_bill = charge + METER_CHARGE;
		
		System.out.println("Total Water bill for " + units_consumed +" is "+ total_water_bill);
		
		scanner.close();
		
	}
}
