package com.adamchilds.daycare.web.login.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests to the login page.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface LoginController {

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String getLogin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="error", required=false) String error);

}