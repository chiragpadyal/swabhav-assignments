package com.swabhav.main.waterbill;

import java.util.Scanner;

public class WaterBillCalculatorReducing {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter units: ");
		int units_consumed = scanner.nextInt();
		int units_consumed_temp = units_consumed;
		final int METER_CHARGE = 75;
		int charge = 0;
		int total_water_bill = 0;
		
		while(units_consumed_temp > 0) {
			if (units_consumed_temp > 250) {
				charge = (units_consumed_temp - 250) * 20;
				units_consumed_temp = 250;
			}else if(units_consumed_temp > 100) {
				charge += (units_consumed_temp - 100) * 10;
				units_consumed_temp = 100;
			}else if(units_consumed_temp <= 100) {
				charge += units_consumed_temp * 5;
				break;
			}
		}
		
		total_water_bill = charge + METER_CHARGE;
		
		System.out.println("Total Water bill for " + units_consumed +" is "+ total_water_bill);
		
		scanner.close();
		
	}
}
