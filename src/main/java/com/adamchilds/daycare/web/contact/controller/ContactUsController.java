package com.adamchilds.daycare.web.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles serving the requests to the 'Contact Us' page.
 */
@Controller
public interface ContactUsController {

    /**
     * Handles GET requests to the 'Contact Us' page.
     *
     * @param modelMap the {@link ModelMap} associated with the request
     */
    @RequestMapping(value = "contact")
    public ModelAndView getContactUsPage(ModelMap modelMap);

}