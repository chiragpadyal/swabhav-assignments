package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.AccountType;
import com.swabhav.model.BankAccount;

public class BankAccountTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long accNumb;
		boolean foundAcc;
		
		BankAccount[] bankAccounts = null;
		boolean isExit = false;
		double maxAmount = 0;
		while(!isExit) {
			System.out.println("Bank Menu: ");
			System.out.println(" 1. Create Accounts \n 2. Debit \n 3. Credit \n 4. Get Maximum Amount \n 5. Display Details  \n . 6. Exit");
			System.out.println("Please choose an option: ");
			int selectedOption = scanner.nextInt();
			switch (selectedOption) {
				case 1:
					System.out.println("Enter number of account to create  : ");
					int noOfAccounts = scanner.nextInt();
					
					bankAccounts = new BankAccount[noOfAccounts];
					for (int i = 0; i < bankAccounts.length; i++) {
						System.out.println("Enter account name: ");
						String name = scanner.next();
						System.out.println("Enter account balance: ");
						double balance = scanner.nextDouble();
						System.out.println("Enter Account Type in number: Default) Salary, 1) Saving, 2) Business 3) Current");
						AccountType accountType;
						
						switch (scanner.nextInt()) {
						case 1:
							accountType = AccountType.Saving;
							break;
						case 2:
							accountType = AccountType.Business;
							break;
						case 3:
							accountType = AccountType.Current;
							break;
						default:
							accountType = AccountType.Salary;
							break;
						}
						bankAccounts[i] = new BankAccount(
								name, balance, accountType
						);
					}
					
					System.out.println("__Created Accounts___");
					for (BankAccount bankAccount : bankAccounts) {
						System.out.println(bankAccount.toString());
					}
					break;
				case 2:
					System.out.println("Enter the amount number: ");
					accNumb = scanner.nextLong();
					foundAcc = false;
					if(bankAccounts != null)
					for (BankAccount bankAccount : bankAccounts) {
						if(bankAccount.getAccountNumber() == accNumb) {
							System.out.println("Enter the amount to debit: ");
							int amount = scanner.nextInt();
							bankAccount.debit(amount);
							foundAcc = true;
							break;
						}
					}
					if(foundAcc) {
						System.out.println("Account not found");
					}
					
					break;
				case 3:
					System.out.println("Enter the amount number: ");
					accNumb = scanner.nextLong();
					foundAcc = false;
					if(bankAccounts != null)
					for (BankAccount bankAccount : bankAccounts) {
						if(bankAccount.getAccountNumber() == accNumb) {
							System.out.println("Enter the amount to credit: ");
							int amount = scanner.nextInt();
							bankAccount.credit(amount);
							foundAcc = true;
							break;
						}
					}
					if(foundAcc) {
						System.out.println("Account not found");
					}
					
					break;
				case 4:
					System.out.println("Calculating maximum amount in all accounts: ");
					if(bankAccounts != null)
					{
						for (BankAccount bankAccount : bankAccounts) {
							maxAmount = Math.max(bankAccount.getBalance(), maxAmount);
						}
						System.out.println("Maximum amount is :" + maxAmount);
					}else {
						System.out.println("No bank accounts exist");
					}
					break;

				case 5:
					System.out.println("Enter the amount number: ");
					accNumb = scanner.nextLong();
					foundAcc = false;
					if(bankAccounts != null)
						for (BankAccount bankAccount : bankAccounts) {
							if(bankAccount.getAccountNumber() == accNumb) {
								System.out.println(bankAccount.toString());
							}
						if(foundAcc) {
							System.out.println("Account not found");
						}
						break;
					}
					break;
				case 6:
					System.out.println("Thank you for using app, Good Bye!");
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
