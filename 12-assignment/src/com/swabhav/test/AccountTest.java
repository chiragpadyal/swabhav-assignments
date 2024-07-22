package com.swabhav.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.swabhav.exception.AccountException;
import com.swabhav.model.Account;
import com.swabhav.model.CurrentAccount;
import com.swabhav.model.SavingsAccount;

public class AccountTest {

	private static List<Account> accounts = new ArrayList<Account>();

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
				"Enter the choice! \n 1. Create bank account \n 2. Access account \n 3. Descending List Accounts By Balance \n 4. Maximum Account By Balance \n 5. Exit");
		int choice = scanner.nextInt();
		Account account = null;
		switch (choice) {
		case 1:
			account = accountCreation(scanner);
			addToArray(accounts, account);
			sortAccounts();
			break;
		case 2:
			account = accountSelection(scanner);
			accountTransaction(scanner, account);
			break;
		case 3:
			System.out.println("Account List by descending balance: ");
			listAccounts();
			break;
		case 4:
			System.out.println("Maximum balance account is: ");
			System.out.println(getMaximumBalanceAccount());
			break;
		case 5:
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
		if (accounts.isEmpty())
			throw new AccountException("No Account exist!");

		for (Account account : accounts) {
			System.out.println("-------------------------------");
			System.out.println(account);
		}
	}

	private static void addToArray(List<Account> oldArray, Account account) {
		oldArray.add(account);
	}
	
	private static void sortAccounts() {
	    int n = accounts.size();
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j < n; j++) {
	            if (accounts.get(i).getBalance() < accounts.get(j).getBalance()) {
	                Account temp = accounts.get(i);
	                accounts.set(i, accounts.get(j));
	                accounts.set(j, temp);
	            }
	        }
	    }
	    
		// one liner
//	    accounts.sort((account1, account2)
//                -> new Double(account1.getBalance()).compareTo(account2.getBalance()));
	}

	private static Account getMaximumBalanceAccount() {
		if(accounts.isEmpty()) throw new AccountException("No account exist");
		return accounts.get(0);
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
