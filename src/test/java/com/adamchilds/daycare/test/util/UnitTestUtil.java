package com.adamchilds.daycare.test.util;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Utility class for unit tests. Includes commonly used code throughout unit tests.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class UnitTestUtil {

    /**
     * Utility method to handle testing form validators that implement {@link Validator}.
     *
     * @param form the form object being tested
     * @param validator the form validator class that implements {@link Validator}
     * @param errorFields the error fields that should exist due to validation issues on the form
     */
    public static void testForm(Object form, Validator validator, String... errorFields) {
        Errors errors = setUpErrors(form);
        validator.validate(form, errors);

        assertHasErrors(errors, errorFields);
    }

    /**
     * Utility method for setting up the {@link org.springframework.validation.Errors} object for validation
     * purposes.
     *
     * @param object the object that will be validated and associated with this Errors object
     * @return the Errors object
     */
    public static Errors setUpErrors(Object object) {
        Errors errors = new BeanPropertyBindingResult(object, object.getClass().getName());

        assertNotNull(errors);

        return errors;
    }

    /**
     * Helper method to reduce redundant assertEquals code in the tests. By passing this method the {@link Errors}
     * object after validation has occurred and the fieldNames expected to be inside of that Errors object, this method
     * will run certain tests based off of the given data.
     *
     * If no {@code fieldNames} are supplied, it's assumed that there should be no errors.
     *
     * @param fieldNames the fieldName(s) associated with the error
     * @param errors     the {@link Errors} object
     */
    public static void assertHasErrors(Errors errors, String... fieldNames) {
        // See if the error count matches the number of fieldNames passed in
        assertEquals(fieldNames.length, errors.getErrorCount());

        if (fieldNames.length > 1) {
            // Make a list of all the error field names
            Set<String> errorFieldNames = new HashSet<>();
            for (FieldError fieldError : errors.getFieldErrors()) {
                errorFieldNames.add(fieldError.getField());
            }

            // See if the supplied field names exist in the errorFieldNames set
            for (String fieldName : fieldNames) {
                assertTrue(errorFieldNames.contains(fieldName));
            }
        } else if (fieldNames.length == 1) {
            assertEquals(fieldNames[0], errors.getFieldErrors().get(0).getField());
        } else {
            assertEquals(0, errors.getFieldErrors().size());
        }
    }

}