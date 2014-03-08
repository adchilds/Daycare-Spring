package com.adamchilds.daycare.web.administration.controller;

import com.adamchilds.daycare.entity.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface AdministrationController {

    /**
     * Displays the home page for the administration dashboard. Logged in users
     * with a role of ROLE_ADMINISTRATOR or ROLE_SUPERUSER from {@link com.adamchilds.daycare.entity.user.enumeration.UserRoleEnum}
     * may use some or all of the utilities provided on these pages.
     *
     * @param modelMap The map that holds information that can be displayed on the page
     * @return A new ModelAndView instance, pointing to the index page of the administration backend
     */
    @RequestMapping(value="/administration/index")
    public ModelAndView getAdmin(ModelMap modelMap);

    /**
     * Executed when the user attempts to delete an entry in the "User List" table.
     *
     * @param userId The id of the User being deleted
     * @param modelMap The map that needs to be updated after the User has been deleted
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable("userId") int userId, ModelMap modelMap);

    /**
     * Executed when the user attempts to update an entry in the "User List" table.
     *
     * @param userId The id of the User being updated
     * @param modelMap The map that needs to be updated after the User has been updated
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("userId") int userId, @ModelAttribute("user") User user, ModelMap modelMap);

}