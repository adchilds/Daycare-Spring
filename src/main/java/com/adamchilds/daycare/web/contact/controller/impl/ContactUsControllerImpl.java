package com.adamchilds.daycare.web.contact.controller.impl;

import com.adamchilds.daycare.web.contact.controller.ContactUsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class ContactUsControllerImpl implements ContactUsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactUsControllerImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public String getContactUsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "contact_us";
    }

}