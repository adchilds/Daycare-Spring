package com.adamchilds.daycare.web.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class SignupController {

    public SignupController() {

    }

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignupPage() {
        return new ModelAndView("/signup");
    }
}