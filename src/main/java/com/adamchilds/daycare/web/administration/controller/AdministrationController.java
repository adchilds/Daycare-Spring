package com.adamchilds.daycare.web.administration.controller;

import com.adamchilds.daycare.entity.user.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests to any administrator (back-end, not public) pages.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface AdministrationController {

    /**
     * Displays the home page for the administration dashboard. Logged in users
     * with a role of ROLE_ADMINISTRATOR or ROLE_SUPERUSER from {@link com.adamchilds.daycare.entity.roles.enumeration.UserRoleEnum}
     * may use some or all of the utilities provided on these pages.
     *
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value="/administration/index.html")
    public String getAdminPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Executed when the user attempts to delete an entry in the "User List" table.
     *
     * @param userId The id of the User being deleted
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/administration/delete/{userId}", method = RequestMethod.GET)
    public String removeUser(@PathVariable("userId") int userId, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * Executed when the user attempts to update an entry in the "User List" table.
     *
     * @param userId The id of the User being updated
     * @param modelMap the {@link ModelMap} associated with the POST request
     * @param request the request
     * @param response the response
     * @return the tiles-def name of the view to render
     */
    @RequestMapping(value = "/administration/update/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") int userId, @ModelAttribute("user") User user, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

}