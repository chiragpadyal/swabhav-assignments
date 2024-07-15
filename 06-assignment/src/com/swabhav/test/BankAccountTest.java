package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.BankAccount;

public class BankAccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccount bankAccount = new BankAccount();
		bankAccount.setName("Raj");
		boolean isExit = false;
		double amount;
		System.out.println("Welocme to your Bank Account " + bankAccount.getName());
		System.out.println("Account Number: " + bankAccount.getAccountNumber());
		while(!isExit) {
			amount = 0;
			System.out.println("Bank Menu: ");
			System.out.println(" 1. Check Balance \n 2. Credit Money \n 3. Debit Money \n 4. Change Name \n 5. Exit");
			System.out.println("Please choose an option: ");
			int selectedOption = scanner.nextInt();
			switch (selectedOption) {
				case 1:
					System.out.println("Your acoount has : " + bankAccount.getBalance());
					break;
				case 2:
					System.out.println("Enter the amount to credit: ");
					amount = scanner.nextDouble();
					bankAccount.credit(amount);
					System.out.println("Your acoount has : " + bankAccount.getBalance());
					break;
				case 3:
					System.out.println("Enter the amount to debit: ");
					amount = scanner.nextDouble();
					bankAccount.debit(amount);
					System.out.println("Your acoount has : " + bankAccount.getBalance());
					break;
				case 4:
					System.out.println("Enter new name: ");
					bankAccount.setName(scanner.next());
					break;
				case 5:
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
