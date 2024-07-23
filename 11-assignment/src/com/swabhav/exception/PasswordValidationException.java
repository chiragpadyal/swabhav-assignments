package com.swabhav.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidationException extends RuntimeException {

    public PasswordValidationException(String message) {
        super(message);
    }

    public static void validatePassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            throw new PasswordValidationException("Password cannot be null or empty.");
        }

        // Check length of password
        if (password.length() < 8 || password.length() > 20) {
            throw new PasswordValidationException("Password length should be between 8 and 20 characters.");
        }

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(password);
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
            	hasNumber = true;
            }
        }
        
        // Check if password contains at least one alphanumeric character
        if (!hasUpperCase) {
            throw new PasswordValidationException("Password must contain at least one uppercase letter.");
        }

        if (!hasNumber) {
            throw new PasswordValidationException("Password must contain at least one numeric character.");
        }
        
        if (!hasSpecial.find()) {
            throw new PasswordValidationException("Password must contain at least one special character.");
        }
        
        
    }
}