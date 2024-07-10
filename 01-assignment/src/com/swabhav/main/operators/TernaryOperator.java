package com.swabhav.main.operators;

import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        int max;

        System.out.println("First num: " + number1);
        System.out.println("Second num: " + number2);

        max = (number1 > number2) ? number1 : number2;

        // Print the largest number
        System.out.println("Maximum is = " + max);
        input.close();
    }
}
