package com.adamchilds.daycare.web.legal.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles request to the legal pages of the site (TOS and Privacy Policy)
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface LegalController {

    /**
     * Handles GET requests for the 'Terms of Service' page
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/terms-of-service.html", method = RequestMethod.GET)
    public String getTermsOfService(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Handles GET requests for the 'Privacy Policy' page
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/privacy-policy.html", method = RequestMethod.GET)
    public String getPrivacyPolicy(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}