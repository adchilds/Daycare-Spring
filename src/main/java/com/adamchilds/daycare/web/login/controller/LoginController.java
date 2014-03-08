package com.adamchilds.daycare.web.login.controller;

import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests to the login page.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface LoginController {

    /**
     * Executed when the user clicks the "Login" button
     *
     * @param loginForm The user credentials for the user attempting to login
     * @param result The result of any errors returned by the validator
     * @param modelMap A map that will persist data for consecutive page loads
     * @return A new ModelAndView instance
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public ModelAndView postLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap);

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView getLogin(ModelMap modelMap);

    /**
     * Handles site authentication for users logging in from the navigation bar
     *
     * @return The same page the user was on, but now as a logged in user if their
     * credentials were correct.
     */
    @RequestMapping(value = "/login-nav.html", method = RequestMethod.POST)
    public ModelAndView postLoginNav(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap);

}