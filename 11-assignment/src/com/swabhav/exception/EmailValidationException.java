package com.swabhav.exception;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException(String message) {
        super(message);
    }

    public static void validateEmail(String email) {
        // Check if email is null or empty
        if (email == null || email.isEmpty()) {
            throw new EmailValidationException("Email cannot be null or empty.");
        }

        // Check length of email
        if (email.length() < 5 || email.length() > 50) {
            throw new EmailValidationException("Email length should be between 5 and 50 characters.");
        }

        // Check if email contains '@' and '.'
        if (!email.contains("@") || !email.contains(".")) {
            throw new EmailValidationException("Email must contain '@' and '.'.");
        }
    }
}