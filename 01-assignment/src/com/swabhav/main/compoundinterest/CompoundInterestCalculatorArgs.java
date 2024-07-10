package com.swabhav.main.compoundinterest;

public class CompoundInterestCalculatorArgs {
    public static void main(String[] args) {

        double principal = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double time = Double.parseDouble(args[2]);
        int number = Integer.parseInt(args[3]);
        
        double interest = calculateCompoundInterest(principal, rate, time, number);

        System.out.println("Principal: " + principal);
        System.out.println("Interest Rate: " + rate);
        System.out.println("Time Duration: " + time);
        System.out.println("Number of Time interest Compounded: " + number);
        System.out.println("Compound Interest: " + interest);
    }

    public static double calculateCompoundInterest(double principal, double rate, double time, int number) {
        double interest = principal * (Math.pow((1 + rate/100), (time * number))) - principal;
        return interest;
    }
}
