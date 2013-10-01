package com.adamchilds.daycare.web.registration.controller;

import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public interface RegistrationController {

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @param modelMap the ModelMap used to store page attributes
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignupPage(ModelMap modelMap);

    /**
     * Handles page requests for submitting a registration form
     *
     * @param modelMap the ModelMap used to store page attributes
     * @param form the form being submitted
     * @param result the BindingResults of the form
     * @return A new ModelAndView instance, dependent upon if there are form errors or not
     */
    @RequestMapping(value = "/submit-registration", method = RequestMethod.POST)
    public ModelAndView submitRegistration(ModelMap modelMap, @ModelAttribute("registrationForm") RegistrationForm form, BindingResult result);

}