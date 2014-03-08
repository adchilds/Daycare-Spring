package com.adamchilds.daycare.web.login.controller;

import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests to the login page.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface LoginController {

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String getLogin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Executed when the user clicks the "Login" button
     *
     * @param loginForm The user credentials for the user attempting to login
     * @param result The result of any errors returned by the validator
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String postLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Handles site authentication for users logging in from the navigation bar
     *
     * @param loginForm The user credentials for the user attempting to login
     * @param result The result of any errors returned by the validator
     * @param modelMap the {@link ModelMap} associated with the GET/POST request
     * @param request the request
     * @param response the response
     * @return The same page the user was on, but now as a logged in user if their
     * credentials were correct.
     */
    @RequestMapping(value = "/login-nav.html", method = RequestMethod.POST)
    public String postLoginNav(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}