package com.adamchilds.daycare.web.contact.controller.impl;

import com.adamchilds.daycare.web.contact.controller.ContactUsController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * {@inheritDoc}
 */
@Controller("contactUsController")
public class ContactUsControllerImpl implements ContactUsController {

    /**
     * {@inheritDoc}
     */
    public ModelAndView getContactUsPage(ModelMap modelMap) {
        return new ModelAndView("/contact");
    }

}