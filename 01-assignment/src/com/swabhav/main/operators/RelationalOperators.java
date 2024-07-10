package com.swabhav.main.operators;

import java.util.Scanner;

public class RelationalOperators {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		a = sc.nextInt();
		System.out.print("Enter second number: ");
		b = sc.nextInt();
		
		System.out.println("a == b:" + (a == b));
		System.out.println("a != b:" + (a != b));
		System.out.println("a > b:" + (a > b));
		System.out.println("a < b:" + (a < b));
		System.out.println("a >= b:" + (a >= b));
		System.out.println("a <= b:" + (a <= b));
		
		sc.close();
	}
}
