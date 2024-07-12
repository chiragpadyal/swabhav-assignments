package com.swabhav.main;

import java.util.Scanner;

public class PeekElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array;
		System.out.println("Enter size of array: ");
		array = new int[scanner.nextInt()];
		
		System.out.println("Enter array elements :");
		for(int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + " element: ");
			array[i] = scanner.nextInt();
		}
		
		int[] peekElementArray;
		peekElementArray = new int[array.length];
		int currentIndex = 0;
		
		if(array[0] >= array[1]) {
			peekElementArray[currentIndex] = array[0];
			currentIndex++;
		}
		for (int i = 1; i < array.length - 1; i++) {
			if(array[i] >= array[i+1] && array[i] >= array[i-1]) {
				peekElementArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		if(array[array.length-1] >= array[array.length-2]) {
			peekElementArray[currentIndex] = array[array.length-1];
			currentIndex++;
		}
		
		System.out.println("Peek Elements are : ");
		for (int i = 0; i < currentIndex; i++) {
			System.out.println("[ " + peekElementArray[i] + " ]");
		}

		scanner.close();
	}
}
