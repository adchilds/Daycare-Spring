package com.adamchilds.daycare.web.home.impl;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.subscription.model.Subscription;
import com.adamchilds.daycare.entity.subscription.service.SubscriptionService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.home.HomeController;
import com.adamchilds.daycare.web.login.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

/**
 * {@inheritDoc}
 */
@Controller
public class HomeControllerImpl implements HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeControllerImpl.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIndexPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postIndexPage(@ModelAttribute("loginForm") LoginForm loginForm, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<User> userList = (ArrayList<User>) userService.readAllUsers();
            Random r = new Random();
            User user = userList.get(r.nextInt(userList.size()));
            Account account = accountService.readAccountById(user.getAccountId());
            Subscription subscription = subscriptionService.readActiveSubscriptionByAccountId(account.getId());
            modelMap.put("user", user);
            modelMap.put("account", account);
            modelMap.put("subscription", subscription);
        } catch (NoResultException nre) {
            System.out.println("Query returned no results.");
        }

        return "index";
    }

}