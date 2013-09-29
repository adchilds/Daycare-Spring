package com.adamchilds.daycare.web.registration.controller;

import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignupPage(ModelMap modelMap) {
        modelMap.put("registrationForm", new RegistrationForm());
        return new ModelAndView("/signup");
    }

}