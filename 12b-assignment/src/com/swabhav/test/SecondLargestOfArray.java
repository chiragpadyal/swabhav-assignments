package com.swabhav.test;

import java.util.Scanner;

public class SecondLargestOfArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {			
			int[] array = createArray(scanner);
			System.out.println("Second Largest is  " + secondLargest(array));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
	}
	
	private static int[] createArray(Scanner scanner) {
		System.out.println("Enter Array size: ");
		int arraySize = scanner.nextInt();
		int[] array = new int[arraySize];
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + " element : ");
			array[i] = scanner.nextInt();
		}
		return array;
	}
	
	private static int secondLargest(int[] array) {
		if(array.length == 1) throw new RuntimeException("No Second Largest element");
		
		// 1st pass
		int largestElement = 0;
		for(int i: array) {
			if(largestElement < i) {
				largestElement = i;
			}
		}
		// 2nd pass
		int secondLarge = Integer.MIN_VALUE;
		for(int i: array) {
			if((secondLarge < i) && (i != largestElement)) {
				secondLarge = i;
			}
		}
		
		if(secondLarge != Integer.MIN_VALUE) return secondLarge;
		throw new RuntimeException("No Second Largest element");		
	}
}
