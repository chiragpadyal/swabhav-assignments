package com.swabhav.model;

import com.swabhav.exception.EmailValidationException;
import com.swabhav.exception.PasswordValidationException;

public class User {

	private String email;
	private String password;

	public User() {
		email = "";
		password = "";
	}

	 public User(String email, String password) {
	        this.setEmail(email);
	        this.setPassword(password);
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email)  {
	    	EmailValidationException.validateEmail(email);
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password)  {
	    	PasswordValidationException.validatePassword(password);
	        this.password = password;
	    }



	    @Override
	    public String toString() {
	        return "User [email=" + email + ", password=" + password + "]";
	    }
	}