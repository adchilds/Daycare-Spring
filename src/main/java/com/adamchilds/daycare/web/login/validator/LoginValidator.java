package com.adamchilds.daycare.web.login.validator;

import com.adamchilds.daycare.entity.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator class for User's. Ensures that the given values for
 * the User's fields are valid as per the specification.
 */
@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class == aClass;
    }

    /**
     * Validates the given User and the supplied data fields.
     *
     * @param obj The User object to validate
     * @param errors Error helper functions
     */
    @Override
    public void validate(Object obj, Errors errors) {
        if (obj.getClass().isAssignableFrom(User.class)) {
            User user = (User) obj;

            // Username validation
            String username = user.getUsername();
            if (StringUtils.hasText(username)) {
                if (username.length() > 24) {
                    errors.rejectValue("username", "", "Username must be 1-24 characters.");
                }
            } else {
                errors.rejectValue("username", "", "You must provide a username.");
            }

            // Password validation
            String password = user.getPassword();
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
    }
}