package com.adamchilds.daycare.web.registration.validator;

import com.adamchilds.daycare.util.validation.model.Validation;
import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationForm.class == aClass;
    }

    /**
     * Validates the given User and the supplied data fields.
     *
     * @param obj The User object to validate
     * @param errors Error helper functions
     */
    @Override
    public void validate(Object obj, Errors errors) {
        if (obj.getClass().isAssignableFrom(RegistrationForm.class)) {
            RegistrationForm form = (RegistrationForm) obj;

            // Email address validation
            String emailAddress = form.getEmailAddress();
            if (StringUtils.hasText(emailAddress)) {
                if (emailAddress.length() > 50) {
                    errors.rejectValue("emailAddress", "", "Email addresses must be less than 50 characters.");
                } else if (emailAddress.length() < 3) {
                    errors.rejectValue("emailAddress", "", "Email addresses must be more than 3 characters.");
                }

/* Maven import not working
                else if (!Validation.isValidEmail(emailAddress)) {
                    errors.rejectValue("emailAddress", "", "Email address is in an invalid format.");
                }
*/
            } else {
                errors.rejectValue("emailAddress", "", "You must provide an email address.");
            }

            // Password validation
            String password = form.getPassword();
            if (StringUtils.hasText(password)) {
                if (password.length() > 30 || password.length() < 7) {
                    errors.rejectValue("password", "", "Password must be 7-30 alphanumeric characters.");
                }
                if (!password.matches(".*\\d.*")) {
                    errors.rejectValue("password", "", "Password must contain at least one number.");
                }
                if (!password.matches(".*[a-zA-Z].*")) {
                    errors.rejectValue("password", "", "Password must contain at least one character.");
                }
            } else {
                errors.rejectValue("password", "", "You must provide a password.");
            }

            // Confirm Password validation
            String confirmPassword = form.getConfirmPassword();
            if (StringUtils.hasText(confirmPassword)) {
                if (confirmPassword.length() > 30 || confirmPassword.length() < 7) {
                    errors.rejectValue("confirmPassword", "", "Password must be 7-30 alphanumeric characters.");
                }
                if (!confirmPassword.matches(".*\\d.*")) {
                    errors.rejectValue("confirmPassword", "", "Password must contain at least one number.");
                }
                if (!confirmPassword.matches(".*[a-zA-Z].*")) {
                    errors.rejectValue("confirmPassword", "", "Password must contain at least one character.");
                }
                // Make sure password and confirm password match
                if (!password.equals(confirmPassword)) {
                    errors.rejectValue("confirmPassword", "", "Passwords do not match.");
                }
            } else {
                errors.rejectValue("confirmPassword", "", "You must confirm your password.");
            }

            if (!StringUtils.hasText(form.getFirstName())) {
                errors.rejectValue("firstName", "", "You must provide your first name.");
            }

            if (!StringUtils.hasText(form.getLastName())) {
                errors.rejectValue("lastName", "", "You must provide your last name");
            }

        }
    }

}