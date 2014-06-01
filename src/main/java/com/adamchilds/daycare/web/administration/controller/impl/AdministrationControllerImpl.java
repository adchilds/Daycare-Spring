package com.adamchilds.daycare.web.administration.controller.impl;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.administration.controller.AdministrationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Controller
public class AdministrationControllerImpl implements AdministrationController {
    private static final Logger logger = LoggerFactory.getLogger(AdministrationControllerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminIndexPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<User> users = (ArrayList<User>) userService.readAllUsers();
        for (User user : users) {
            accounts.add(accountService.readAccountById(user.getAccountId()));
        }
        modelMap.put("userList", users);
        modelMap.put("accountList", accounts);

        return "administration_index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminUserAccountsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "administration_accounts";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String removeUser(@PathVariable("userId") int userId, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.readAllUsers();

        User userToDelete;
        try {
            // Remove the User from the database
            userToDelete = userService.read(new Integer(userId).longValue());
            userService.remove(userToDelete);

            // Remove the User from the List<User>
            userList.remove(userToDelete);
        } catch (NullPointerException | IllegalArgumentException e) {
            // Nothing needs to be done except for a page reload. Reload will handle fixing the table.
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return "administration_index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String updateUser(@PathVariable("userId") int userId, @ModelAttribute("user") User user, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
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

        return "administration_index";
    }

}