package com.adamchilds.daycare.web.errors;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles common web request errors such as 404, 500, etc.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface ErrorsController {

    /**
     * Handles serving the 404 page.
     *
     * @param modelMap the {@link ModelMap} associated with the GET/POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/404.html")
    public String get404(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}