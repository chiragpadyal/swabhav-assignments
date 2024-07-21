package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.exception.EmailValidationException;
import com.swabhav.exception.PasswordValidationException;
import com.swabhav.model.User;

public class UserTest {
	 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			User user = new User();
			System.out.println("Enter email id:");
			String email = scanner.next();
			user.setEmail(email);
			System.out.println("Enter password:");
			String password = scanner.next();
			user.setPassword(password);
 
			System.out.println("User Email is Valid: "+user.getEmail());
			System.out.println("User password is Valid: "+user.getPassword() );
 
		}catch(EmailValidationException exception) {
			System.out.println(exception.getMessage());
		} catch(PasswordValidationException exception) {
			System.out.println(exception.getMessage());
		} catch(Exception exception) {
			System.out.println("Wrong input");
		}finally{
			scanner.close();
		}
	}
}