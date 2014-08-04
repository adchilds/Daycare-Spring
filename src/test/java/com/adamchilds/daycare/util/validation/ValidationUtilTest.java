package com.adamchilds.daycare.util.validation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the {@link ValidationUtil} class
 */
public class ValidationUtilTest {

    @Test
    public void testIsValidCreditCardNumber() {
        // Null
        String creditCardNumber = null;
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Empty
        creditCardNumber = "";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Whitespace
        creditCardNumber = "    ";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Random string
        creditCardNumber = "Lets eat out for dinner.";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Too many numbers
        creditCardNumber = "12345678901234567890";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Too few numbers
        creditCardNumber = "1234";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Invalid number
        creditCardNumber = "1234123412341234";
        assertFalse(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Valid number (American Express)
        creditCardNumber = "378282246310005";
        assertTrue(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Valid number (Discover)
        creditCardNumber = "6011111111111117";
        assertTrue(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Valid number (Mastercard)
        creditCardNumber = "5555555555554444";
        assertTrue(ValidationUtil.isValidCreditCardNumber(creditCardNumber));

        // Valid number (Visa)
        creditCardNumber = "4111111111111111";
        assertTrue(ValidationUtil.isValidCreditCardNumber(creditCardNumber));
    }

    @Test
    public void testIsValidEmail() {
        // Null
        String email = null;
        assertFalse(ValidationUtil.isValidEmail(email));

        // Empty
        email = "";
        assertFalse(ValidationUtil.isValidEmail(email));

        // Whitespace
        email = "    ";
        assertFalse(ValidationUtil.isValidEmail(email));

        // Random string
        email = "Hello world";
        assertFalse(ValidationUtil.isValidEmail(email));

        // No @ symbol
        email = "testtest.com";
        assertFalse(ValidationUtil.isValidEmail(email));

        // No .
        email = "test@testcom";
        assertFalse(ValidationUtil.isValidEmail(email));

        // No text before @
        email = "@test.com";
        assertFalse(ValidationUtil.isValidEmail(email));

        // No text after @
        email = "test@";
        assertFalse(ValidationUtil.isValidEmail(email));

        // Valid
        email = "test@test.com";
        assertTrue(ValidationUtil.isValidEmail(email));
    }

}