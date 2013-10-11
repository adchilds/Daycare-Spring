package com.adamchilds.daycare.web.administration.controller.impl;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.administration.controller.AdministrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller("administrationController")
public class AdministrationControllerImpl implements AdministrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Override
    public ModelAndView getAdmin(ModelMap modelMap) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        ArrayList<User> users = (ArrayList<User>) userService.readAllUsers();
        for (User user : users) {
            accounts.add(accountService.readAccountById(user.getAccountId()));
        }
        modelMap.put("userList", users);
        modelMap.put("accountList", accounts);
        return new ModelAndView("/administration/index");
    }

}