package com.adamchilds.daycare.util.validation.model;

import org.apache.commons.validator.routines.EmailValidator;

public class Validation {

    /**
     * Parses the given email address and returns whether or not it's in the
     * correct format.
     *
     * @param emailAddress the email address to parse
     * @return true if the email address is in the correct format; false otherwise
     */
    public static boolean isValidEmail(String emailAddress) {
        EmailValidator emailValidator = EmailValidator.getInstance();

        return emailValidator.isValid(emailAddress);
    }

}