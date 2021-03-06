package com.adamchilds.daycare.web.login.validator;

import com.adamchilds.daycare.web.login.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator class for User's. Ensures that the given values for
 * the User's fields are valid as per the specification.
 */
@Component
public class LoginFormValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(LoginFormValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginForm.class == aClass;
    }

    /**
     * Validates the given User and the supplied data fields.
     *
     * @param obj The User object to validate
     * @param errors Error helper functions
     */
    @Override
    public void validate(Object obj, Errors errors) {
        if (obj != null) {
            if (obj.getClass().isAssignableFrom(LoginForm.class)) {
                LoginForm form = (LoginForm) obj;

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
            }
        } else {
            errors.reject("", "Something went wrong. The engineers have been notified.");

            logger.error("The form object passed to the LoginFormValidator was null!");
        }
    }
}