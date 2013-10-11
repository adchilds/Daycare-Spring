package com.adamchilds.daycare.web.legal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles the legal pages of the site (TOS and Privacy Policy)
 */
@Controller
public interface LegalController {

    @RequestMapping(value = "/tos", method = RequestMethod.GET)
    public ModelAndView getTermsOfService(ModelMap modelMap);

    @RequestMapping(value = "/privacy", method = RequestMethod.GET)
    public ModelAndView getPrivacyPolicy(ModelMap modelMap);

}