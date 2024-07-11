package com.swabhav.main;

import java.util.Scanner;

public class AtmMachine {
	
	void checkBalane(double balance){
		System.out.println("Your current balance is: " + balance);
	}
	
	double depositeMoney(double balance, Scanner scanner) {
		System.out.println("Enter amount to be deposit: ");
		double depositAmount = scanner.nextDouble();
		System.out.println("You have deposited: $" + depositAmount);
		System.out.println("Your new balance is $" + (balance + depositAmount));
		return balance + depositAmount;
	}
	
	double withdrawMoney(double balance, Scanner scanner) {
		System.out.println("Enter amount to be withdraw: ");
		double withdrawnAmount = scanner.nextDouble();
		if(withdrawnAmount <= balance) {
			System.out.println("You have wihdrawn: $" + withdrawnAmount);
			System.out.println("Your new balance is $" + (balance - withdrawnAmount));
			return balance - withdrawnAmount;
		}
		System.out.println("You have insufficient balance!");
		this.checkBalance(balance);
		return balance;
	}
	
	void checkBalance(double balance){
		System.out.println("Your current balance is: " + balance);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AtmMachine atmMachine = new AtmMachine();

		double balance = 0;
		boolean isExit = false;

		while(!isExit) {
			System.out.println("ATM Menu: ");
			System.out.println(" 1. Check Balance \n 2. Deposite Money \n 3. Withdrw Money \n 4. Exit");
			System.out.println("Please choose an option: ");
			int selectedOption = scanner.nextInt();
			switch (selectedOption) {
				case 1:
					atmMachine.checkBalance(balance);
					break;
				case 2:
					balance = atmMachine.depositeMoney(balance, scanner);
					break;
				case 3:
					balance = atmMachine.withdrawMoney(balance, scanner);
					break;
				case 4:
					System.out.println("Thank you for using atm, Good Bye!");
					isExit = true;
					break;
				default:
					System.out.println("Wrong choice!");
					break;
				}
		}
		
		scanner.close();
	}
}
