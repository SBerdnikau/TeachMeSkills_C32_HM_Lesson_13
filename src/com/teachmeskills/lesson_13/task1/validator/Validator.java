package com.teachmeskills.lesson_13.task1.validator;

import com.teachmeskills.lesson_13.task1.exception.WrongLoginException;
import com.teachmeskills.lesson_13.task1.exception.WrongPasswordException;

public class Validator {

    public static boolean validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (login.length() >= 20 || login.contains(" ")) {
            throw new WrongLoginException("Login must be less than 20 characters long and must not contain spaces.");
        }

        if (password.length() >= 20 || password.contains(" ") || !containsDigit(password) || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("The password must be less than 20 characters long, must not contain spaces, must contain at least one number, and must match the confirmation.");
        }

        return true;
    }

    private static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}