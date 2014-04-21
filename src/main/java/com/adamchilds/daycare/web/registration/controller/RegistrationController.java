package com.adamchilds.daycare.web.registration.controller;

import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests to the registration pages.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface RegistrationController {

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String getSignupPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Handles page requests for submitting a registration form
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param form the form being submitted
     * @param result the BindingResults of the form
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String submitRegistration(ModelMap modelMap, @ModelAttribute("registrationForm") RegistrationForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response);

}