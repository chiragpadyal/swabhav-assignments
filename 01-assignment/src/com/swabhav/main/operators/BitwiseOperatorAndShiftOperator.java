package com.swabhav.main.operators;

import java.util.Scanner;

public class BitwiseOperatorAndShiftOperator {

	public static void main(String[] args) {
		int number1 = 0;
		int number2 = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		number1 = sc.nextInt();
		System.out.print("Enter second number: ");
		number2 = sc.nextInt();
		
		System.out.println("Value of first number is " + number1);
		System.out.println("Value of second number is " + number2);
		
		System.out.println("bitwise and operator " + (number1 & number2));
		System.out.println("bitwise or operator " + (number1 | number2));
		System.out.println("bitwise xor operator " + (number1 ^ number2));
		System.out.println("bitwise complement operator for number1 " + (~number1));
        System.out.println("Bitwise Left Shift by 2 on number1: " + (number1 << 2));
        System.out.println("Bitwise Right Shift by 2 on number1: " + (number1 >> 2));
        System.out.println("Bitwise Unsigned Right Shift by 2 on number1: " + (number1 >>> 2));
		sc.close();
	}
}
