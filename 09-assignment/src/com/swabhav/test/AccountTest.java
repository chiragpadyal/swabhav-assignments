package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.Account;
import com.swabhav.model.CurrentAccount;
import com.swabhav.model.SavingsAccount;

public class AccountTest {
	
	private static Account accountCreation(Scanner scanner) {
		System.out.println("Choose Account Type");
		System.out.println("1. Saving");
		System.out.println("2. Current");
		int choice = scanner.nextInt();
		

		System.out.println("enter account name: ");
		String name = scanner.next();
		System.out.println("enter account balance: ");
		double balance = scanner.nextDouble();
		Account bankAccount;
		
		switch (choice) {
		case 1:
			System.out.println("enter MIN_BALANCE: ");
			double MIN_BALANCE = scanner.nextDouble();
			bankAccount = new SavingsAccount(name, balance, MIN_BALANCE);
			return bankAccount;
		case 2:
			System.out.println("enter OVER_DRAFT_LIMIT: ");
			double OVER_DRAFT_LIMIT = scanner.nextDouble();
			bankAccount = new CurrentAccount(name, balance, OVER_DRAFT_LIMIT);
			return bankAccount;
		default:
			break;
		}
		
		return null;
		
	}
	
	private static void accountTransaction(Scanner scanner, Account bankAccount) {
		System.out.println("Enter the choice! \n 1. check balance \n 2. credit \n 3. debit \n 4.Exit");
		int choice = scanner.nextInt();
		double amount;
		switch (choice) {
		case 1:
			System.out.println(bankAccount.toString());
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
			System.out.println("Thank you for using app, Good Bye!");
			return;
		default:
			break;
		}
		AccountTest.accountTransaction(scanner, bankAccount);
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Account account = accountCreation(scanner);
		if(account == null) {
			System.out.println("Failed to create account!");
			System.exit(0);
		}
		accountTransaction(scanner, account);
		scanner.close();
	}
}
