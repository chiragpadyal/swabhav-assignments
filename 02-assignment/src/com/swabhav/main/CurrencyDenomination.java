package com.swabhav.main;

import java.util.Scanner;

public class CurrencyDenomination {
	public static void main(String[] args) {
		System.out.println("Enter withdrawl amount: ");
		Scanner scanner = new Scanner(System.in);
		int amount = scanner.nextInt();
		int amountOf2000 = 0;
		int amountOf500 = 0;
		int amountOf200 = 0;
		int amountOf100 = 0;
		
		if(amount > 50000) {
			System.out.println("Amount exceeds withdrawal limit of 50000!");
		} else if(amount % 100 != 0) {
			System.out.println("Amount should be multiples of 100!");
		} else {
	        amountOf2000 = amount / 2000;
	        amount = amount % 2000;
	        if (amountOf2000 != 0)
	        System.out.println("Two Thousand: " + amountOf2000);
	        
	        amountOf500 = amount / 500;
	        amount = amount % 500;
	        if (amountOf500 != 0)
	        System.out.println("Five Hundred: " + amountOf500);
	        
	        amountOf200 = amount / 200;
	        amount = amount % 200;
	        if (amountOf200 != 0)
	        System.out.println("Two Hundred: " + amountOf200);
	        
	        amountOf100 = amount / 100;
	        amount = amount % 100;
	        if (amountOf100 != 0)
	        System.out.println("Hundred: " + amountOf100);
		}
        
		scanner.close();
	}
}
