package com.adamchilds.daycare.util.validation;

import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * This class provides useful functions for form validation processes.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class ValidationUtil {

    /**
     * Parses the given credit card number and returns whether or not it is a
     * valid credit card number based on the Luhn algorithm.
     *
     * @param creditCardNumber the credit card number to verify the validity of
     * @return true if the credit card number is in the correct format; false otherwise
     */
    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        CreditCardValidator creditCardValidator = new CreditCardValidator();

        return creditCardValidator.isValid(creditCardNumber);
    }

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