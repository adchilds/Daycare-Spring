package com.adamchilds.daycare.web.pricing.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the pages that show Daycare Management System pricing information
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface PricingController {

    /**
     * Handles GET requests for the 'Pricing' page
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/pricing.html", method = RequestMethod.GET)
    public String getPricingPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}