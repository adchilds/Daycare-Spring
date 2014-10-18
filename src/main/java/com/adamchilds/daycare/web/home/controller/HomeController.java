package com.adamchilds.daycare.web.home.controller;

import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests to the site home/index page.
 *
 * @author Adam Childs
 * @since 1.0
 */
@RequestMapping(value={"", "/", "/index.html"}) // Map these URIs to this controller
public interface HomeController {

    /**
     * Handles GET requests to the home/index page.
     *
     * @param modelMap the {@link ModelMap} associated with the GET request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Handles POST requests to the home/index page.
     *
     * @param loginForm the {@link LoginForm} associated with the POST request
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(method = RequestMethod.POST)
    public String postIndexPage(@ModelAttribute("loginForm") LoginForm loginForm, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}