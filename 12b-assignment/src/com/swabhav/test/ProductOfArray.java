package com.swabhav.test;

import java.util.Scanner;

public class ProductOfArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {			
			int[] array = createArray(scanner);
			int[] productArray =  productArray(array);
			printArray(productArray);
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
	
	private static int[] productArray(int[] array) {
		int[] productArray = new int[array.length];
		
		if(array.length == 1) return array;
		
		for (int i = 0; i < productArray.length; i++) {
			int product = 1;
			for (int j = 0; j < productArray.length; j++) {
				if(i != j) product*=array[j];
			}
			productArray[i] = product;
		}
		
		return productArray;
	}
	
	private static void printArray(int[] array) {
		System.out.println("------------Product Array-------------");
		for (int i : array) {
			System.out.println(i);
		}
	}
	
}
