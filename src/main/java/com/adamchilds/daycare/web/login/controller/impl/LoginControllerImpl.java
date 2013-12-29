package com.adamchilds.daycare.web.login.controller.impl;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.login.controller.LoginController;
import com.adamchilds.daycare.web.login.form.LoginForm;
import com.adamchilds.daycare.web.login.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginControllerImpl implements LoginController {

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
    public ModelAndView getLogin(ModelMap modelMap) {
        modelMap.put("user", new User());
        return new ModelAndView("/login", modelMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView postLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap) {
        // Check for validation errors
        validator.validate(loginForm, result);
        if (result.hasErrors()) {
            modelMap.put("loginForm", loginForm);
            return new ModelAndView("/login", modelMap);
        }

        // "redirect:/dashboard.html" goes to a dashboard.html page but doesn't carry over the data from modelMap
        return new ModelAndView(new RedirectView("/index"), modelMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView postLoginNav(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap) {
        // Check for validation errors
        validator.validate(loginForm, result);
        if (result.hasErrors()) {
            modelMap.put("loginForm", loginForm);
            return new ModelAndView("/login", modelMap);
        }

        return new ModelAndView("/index", modelMap);
    }

}