package com.swabhav.main;

import java.util.Scanner;

public class PrimeNumberPattern {
	boolean isPrime(int number) {
	       if (number <= 1) {  
	           return false;  
	       }  
	       for (int i = 2; i < number; i++) {  
	           if (number % i == 0) {  
	               return false;  
	           }  
	       }  
	       return true;  
	}
	
	int findNextPrime(int currentPrime) {
	    int newPrime = currentPrime + 1;
	    
	    while (!isPrime(newPrime)) {
	        newPrime++;
	    }
	    
	    return newPrime;
	}
   
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PrimeNumberPattern primeNumberPattern = new PrimeNumberPattern();
		System.out.println("Enter Number of lines :");
		int currentPrime = 1;
		int lines = scanner.nextInt();
		for (int i = 1; i <= lines; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(currentPrime + "\t");
				currentPrime = primeNumberPattern.findNextPrime(currentPrime);
			};
			System.out.println();
		}
		
		
		
		scanner.close();
	}
}
