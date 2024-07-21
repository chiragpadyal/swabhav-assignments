package com.swabhav.test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.swabhav.exception.AccountException;
import com.swabhav.model.Account;
import com.swabhav.model.CurrentAccount;
import com.swabhav.model.SavingsAccount;

public class AccountTest {

	private static Account[] accounts = new Account[0];

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
		System.out.println("Enter the choice! \n 1. check details \n 2. credit \n 3. debit \n 4.Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Your acoount has : " + bankAccount.toString());
			break;
		case 2:
			runCredit(scanner, bankAccount);
			break;
		case 3:
			runDebit(scanner, bankAccount);
			break;
		case 4:
			System.out.println("Thank you for using app, Good Bye!");
			return;
		default:
			break;
		}
		AccountTest.accountTransaction(scanner, bankAccount);
	}

	private static void menu(Scanner scanner) {
		System.out.println(
				"Enter the choice! \n 1. create bank account \n 2. access account \n 3. List Accounts \n 4.Exit");
		int choice = scanner.nextInt();
		Account account = null;
		switch (choice) {
		case 1:
			account = accountCreation(scanner);
			addToArray(accounts, account);
			break;
		case 2:
			account = accountSelection(scanner);
			accountTransaction(scanner, account);
			break;
		case 3:
			System.out.println("Account List: ");
			listAccounts();
			break;
		case 4:
			System.out.println("Thank you for using app, Good Bye!");
			return;
		default:
			break;
		}
		menu(scanner);
	}

	private static void runCredit(Scanner scanner, Account bankAccount) {
		System.out.println("Enter the amount to credit: ");
		try {
			double amount = scanner.nextDouble();
			bankAccount.credit(amount);
		} catch (AccountException exception) {
			System.out.println(exception.getMessage());
		} catch (NumberFormatException exception) {
			System.out.println("Enter valid number");
		}
		System.out.println("Your acoount has : " + bankAccount.getBalance());
	}

	private static void runDebit(Scanner scanner, Account bankAccount) {
		try {
			System.out.println("Enter the amount to debit: ");
			double amount = scanner.nextDouble();
			bankAccount.debit(amount);
		} catch (AccountException exception) {
			System.out.println(exception.getMessage());
		} catch (NumberFormatException exception) {
			System.out.println("Enter valid number");
		}
		System.out.println("Your acoount has : " + bankAccount.getBalance());
	}

	private static void listAccounts() {
		if (accounts[0] == null)
			throw new AccountException("No Account exist!");

		for (Account account : accounts) {
			System.out.println(account.getAccountNumber());
		}
	}

	private static void addToArray(Account[] oldArray, Account account) {
		Account[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
		newArray[oldArray.length] = account;
		accounts = newArray;
	}

	private static Account accountSelection(Scanner scanner) {
		System.out.println("Enter the account number: ");
		long accountNumber = scanner.nextLong();
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber)
				return account;
		}
		throw new AccountException("Wrong Account Number!");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			menu(scanner);
		} catch (AccountException exception) {
			System.out.println(exception.getMessage());
		} catch (InputMismatchException exception) {
			System.out.println("Wrong input!");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			scanner.close();
		}
	}
}
