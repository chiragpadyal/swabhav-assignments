package com.swabhav.main;

import java.util.Scanner;

public class SortedSquare {
	
	private static int[] squareSort(int[] array){
		int[] sortedSquareArray = new int[array.length];
		int[] arrayCopy = array;
		int left = 0;
		int right = array.length -1;
		int mainIndex = array.length -1;
		
		for (int i = 0; i < arrayCopy.length; i++) {
			arrayCopy[i] = (int) Math.pow(arrayCopy[i], 2);
		}
		
		while(left <= right) {
			if(array[left] > array[right]) {
				sortedSquareArray[mainIndex] = array[left];
				mainIndex--;
				left++;
			}else {
				sortedSquareArray[mainIndex] = array[right];
				mainIndex--;
				right--;
			}
		}
		return sortedSquareArray;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array;
		int[] sortedSquareArray;
		
		System.out.println("Enter size of array: ");
		array = new int[scanner.nextInt()];
		sortedSquareArray = array;
		
		System.out.println("Enter sorted array elements :");
		for(int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + " element: ");
			array[i] = scanner.nextInt();
		}
		
		//Print array
		System.out.println("Printed Array : ");
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			 System.out.print(array[i] + ","); 
		}
		System.out.print(array[array.length - 1] + "]");
		
		// main sort
		sortedSquareArray = squareSort(array);
		
		//Print sorted square array
		System.out.println("\nPrinted Sorted Square Array : ");
		System.out.print("[");
		for (int i = 0; i < sortedSquareArray.length - 1; i++) {
			 System.out.print(sortedSquareArray[i] + ","); 
		}
		System.out.print(sortedSquareArray[sortedSquareArray.length - 1] + "]");
		
		scanner.close();
	}

}
