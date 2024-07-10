package com.swabhav.main.compoundinterest;

import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the time period in years: ");
        double time = scanner.nextDouble();
        
        System.out.print("Enter number of times interest is compounded: ");
        int number = scanner.nextInt();

        double interest = calculateCompoundInterest(principal, rate, time, number);

        System.out.println("Principal: " + principal);
        System.out.println("Interest Rate: " + rate);
        System.out.println("Time Duration: " + time);
        System.out.println("Number of Time interest Compounded: " + number);
        System.out.println("Compound Interest: " + interest);
        scanner.close();
    }

    public static double calculateCompoundInterest(double principal, double rate, double time, int number) {
        double interest = principal * (Math.pow((1 + rate/100), (time * number))) - principal;
        return interest;
    }
}
