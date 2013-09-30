package com.adamchilds.daycare.web.registration.validator;

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

            // Username validation
            String username = form.getUsername();
            if (StringUtils.hasText(username)) {
                if (username.length() > 24) {
                    errors.rejectValue("username", "", "Username must be 1-24 characters.");
                }
            } else {
                errors.rejectValue("username", "", "You must provide a username.");
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
                    errors.rejectValue("password", "", "Password must be 7-30 alphanumeric characters.");
                }
                if (!confirmPassword.matches(".*\\d.*")) {
                    errors.rejectValue("password", "", "Password must contain at least one number.");
                }
                if (!confirmPassword.matches(".*[a-zA-Z].*")) {
                    errors.rejectValue("password", "", "Password must contain at least one character.");
                }
            } else {
                errors.rejectValue("password", "", "You must provide a password.");
            }

            // Make sure password and confirm password match
            if (!password.equals(confirmPassword)) {
                errors.rejectValue("confirmPassword", "", "Passwords do not match.");
            }

        }
    }

}