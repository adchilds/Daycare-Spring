package com.adamchilds.daycare.web.login.controller.impl;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
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
    public String getLogin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        modelMap.put("user", new User());

        return "login";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        // Check for validation errors
        validator.validate(loginForm, result);
        if (result.hasErrors()) {
            modelMap.put("loginForm", loginForm);
            return "login";
        }

        return "index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postLoginNav(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        // Check for validation errors
        validator.validate(loginForm, result);
        if (result.hasErrors()) {
            modelMap.put("loginForm", loginForm);
            return "login";
        }

        return "index";
    }

}