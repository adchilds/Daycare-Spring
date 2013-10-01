package com.adamchilds.daycare.web.login.controller;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.web.login.validator.LoginValidator;
import com.adamchilds.daycare.entity.user.service.UserService;
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
    private UserService userService;

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
            return new ModelAndView("/login", modelMap);
        } else {
            // Remove the user from the modelMap since we don't want the username and password
            // to stay in their appropriate textfield when the page reloads
            modelMap.remove(user);
        }

        // Persist new user data
        userService.create(user);
        userService.update(user);

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
        return new ModelAndView("/login", modelMap);
    }

    /**
     * Executed when the user attempts to delete an entry in the "User List" table.
     *
     * @param userId The id of the User being deleted
     * @param modelMap The map that needs to be updated after the User has been deleted
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable("userId") int userId, ModelMap modelMap) {
        List<User> userList = (ArrayList<User>) userService.readAllUsers();

        User userToDelete;
        try {
            // Remove the User from the database
            userToDelete = userService.read(new Integer(userId).longValue());
            userService.remove(userToDelete);

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
     * @param userId The id of the User being updated
     * @param modelMap The map that needs to be updated after the User has been updated
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("userId") int userId, @ModelAttribute("user") User user, ModelMap modelMap) {
        System.out.println("IN UPDATEUSER method");
        List<User> userList = userService.readAllUsers();
        User userToUpdate = userService.read(new Integer(userId).longValue());

        System.out.println("NEW USER: " + user);
        System.out.println("userToUpdate in updateUser() method (BEFORE): " + userToUpdate);

        try {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());

            System.out.println("userToUpdate in updateUser() method (AFTER): " + userToUpdate);

            userService.update(userToUpdate);

            System.out.println("NEW USER IN DATABASE: " + userService.read(new Integer(userId).longValue()));
        } catch (NullPointerException e) {
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return new ModelAndView(new InternalResourceView("/login"), modelMap);
    }
}