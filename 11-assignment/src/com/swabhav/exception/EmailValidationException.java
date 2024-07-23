package com.swabhav.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException(String message) {
        super(message);
    }

    public static void validateEmail(String email) {
        // Check if email is null or empty
        if (email == null || email.isEmpty()) {
            throw new EmailValidationException("Email cannot be null or empty.");
        }

        //Regular Expression   
        // another regex: "(^[a-zA-Z0-9_.]+[@]{1}[a-z0-9]+[\.][a-z]+$)"
        String regex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";  
  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
        Matcher match = pattern.matcher(email);

        if(!match.find()) {
        	throw new EmailValidationException("Email not valid.");
        }
        
    }
}