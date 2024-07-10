package com.swabhav.main.operators;

import java.util.Scanner;

public class LogicalOperators {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 'a' true/false: ");
		boolean a = sc.nextBoolean();
		System.out.print("Enter 'b' true/false: ");
		boolean b = sc.nextBoolean();
		
		System.out.println("Value of a is " + a);
		System.out.println("Value of b is " + b);
		
		System.out.println("a and b is " + (a && b));
		System.out.println("a or b is " + (a || b));
		System.out.println("not a is " + (!a));
		System.out.println("not b is " + (!b));
		sc.close();
	}
}
