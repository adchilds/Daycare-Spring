package com.adamchilds.daycare.web.contact.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles serving the requests to the 'Contact Us' page.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface ContactUsController {

    /**
     * Handles GET requests to the 'Contact Us' page.
     *
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/contact.html")
    public String getContactUsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}