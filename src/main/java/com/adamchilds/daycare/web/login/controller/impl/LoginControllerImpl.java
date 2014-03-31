package com.adamchilds.daycare.web.login.controller.impl;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.login.LoginConstants;
import com.adamchilds.daycare.web.login.controller.LoginController;
import com.adamchilds.daycare.web.login.form.LoginForm;
import com.adamchilds.daycare.web.login.validator.LoginValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class LoginControllerImpl implements LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerImpl.class);

    // Used if we want to write a custom Validator
    @Autowired
    private LoginValidator validator;

    // Our service which allows us to execute operations
    // on the database given a User
    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLogin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="error", required=false) String error) {
        modelMap.put("user", new User());

        if (error != null) {

            String errorMessage;
            switch (error) {
                case LoginConstants.ERROR_BAD_CREDENTIALS:
                    errorMessage = "Invalid username or password.";
                    break;

                case LoginConstants.ERROR_EXPIRED_CREDENTIALS:
                    errorMessage = "This user's credentials have expired.";
                    break;

                case LoginConstants.ERROR_ACCOUNT_DISABLED:
                    errorMessage = "This account is disabled";
                    break;

                case LoginConstants.ERROR_ACCOUNT_LOCKED:
                    errorMessage = "This account has been locked.";
                    break;

                default:
                    errorMessage = "There was an error while attempting to login. Please try again. If the problem persists, please contact customer support.";
                    logger.warn("Unhandled Spring authentication error on user login. error=[" + error + "]");
                    break;
            }

            modelMap.put("error", errorMessage);
        }

        return "login";
    }

}