package com.adamchilds.daycare.entity.user.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator class for UserModel's. Ensures that the given values for
 * the UserModel's fields are valid as per the specification.
 */
@Component
public class UserModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserModel.class == aClass;
    }

    /**
     * Validates the given UserModel and the supplied data fields.
     *
     * @param obj The UserModel object to validate
     * @param errors Error helper functions
     */
    @Override
    public void validate(Object obj, Errors errors) {
        if (obj.getClass().isAssignableFrom(UserModel.class)) {
            UserModel userModel = (UserModel) obj;

            // Username validation
            String username = userModel.getUsername();
            if (!username.equals("")) {
                if (username.length() > 20) {
                    errors.rejectValue("username", "", "Username must be 1-20 characters.");
                }
            } else {
                errors.rejectValue("username", "", "You must provide a username.");
            }

            // Password validation
            String password = userModel.getPassword();
            if (!password.equals("")) {
                if (password.length() > 20 || password.length() < 7) {
                    errors.rejectValue("password", "", "Password must be 7-20 alphanumeric characters.");
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