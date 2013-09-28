package com.adamchilds.daycare.web.login.controller;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.web.login.validator.LoginValidator;
import com.adamchilds.daycare.entity.user.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the login page's functionality
 */
@Controller
class LoginController {

    // Used if we want to write a custom Validator
    @Autowired
    private LoginValidator validator;

    // Our service which allows us to execute operations
    // on the database given a User
    @Autowired
    private UserModelService userModelService;

    /**
     * Executed when the user clicks the "Login" button
     *
     * @param user The new User being created and persisted to the database
     * @param result The result of any errors returned by the validator
     * @param modelMap A map that will persist data for consecutive page loads
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView postLogin(@ModelAttribute("user") User user, BindingResult result, ModelMap modelMap) {
        // Check for validation errors
        validator.validate(user, result);
        if (result.hasErrors()) {
            modelMap.put("user", user);
            modelMap.put("userModelList", userModelService.readAllUsers());
            return new ModelAndView("/login", modelMap);
        } else {
            // Remove the user from the modelMap since we don't want the username and password
            // to stay in their appropriate textfield when the page reloads
            modelMap.remove(user);
        }

        // Persist new user data
        userModelService.create(user);
        userModelService.update(user);

        modelMap.put("userModelList", userModelService.readAllUsers());

        // "redirect:/dashboard.html" goes to a dashboard.html page but doesn't carry over the data from modelMap
        return new ModelAndView("/index", modelMap);
    }

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin(ModelMap modelMap) {
        modelMap.put("user", new User());
        modelMap.put("userList", userModelService.readAllUsers());
        return new ModelAndView("/login", modelMap);
    }

    /**
     * Executed when the user attempts to delete an entry in the "User List" table.
     *
     * @param userModelId The id of the User being deleted
     * @param modelMap The map that needs to be updated after the User has been deleted
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/delete/{userModelId}", method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable("userModelId") int userModelId, ModelMap modelMap) {
        List<User> userList = (ArrayList<User>) userModelService.readAllUsers();

        User userToDelete;
        try {
            // Remove the User from the database
            userToDelete = userModelService.read(new Integer(userModelId).longValue());
            userModelService.remove(userToDelete);

            // Remove the User from the List<User>
            userList.remove(userToDelete);
        } catch (NullPointerException|IllegalArgumentException e) {
            // Nothing needs to be done except for a page reload. Reload will handle fixing the table.
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return new ModelAndView(new InternalResourceView("/login"), modelMap);
    }

    /**
     * Executed when the user attempts to update an entry in the "User List" table.
     *
     * @param userModelId The id of the User being updated
     * @param modelMap The map that needs to be updated after the User has been updated
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/update/{userModelId}", method = RequestMethod.GET)
    public ModelAndView updateUserModel(@PathVariable("userModelId") int userModelId, @ModelAttribute("user") User user, ModelMap modelMap) {
        System.out.println("IN UPDATEUSERMODEL method");
        List<User> userList = userModelService.readAllUsers();
        User userToUpdate = userModelService.read(new Integer(userModelId).longValue());

        System.out.println("NEW USER_MODEL: " + user);
        System.out.println("userToUpdate in updateUserModel() method (BEFORE): " + userToUpdate);

        try {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());

            System.out.println("userToUpdate in updateUserModel() method (AFTER): " + userToUpdate);

            userModelService.update(userToUpdate);

            System.out.println("NEW USER_MODEL IN DATABASE: " + userModelService.read(new Integer(userModelId).longValue()));
        } catch (NullPointerException e) {
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return new ModelAndView(new InternalResourceView("/login"), modelMap);
    }
}