package com.adamchilds.daycare.web;

import com.adamchilds.daycare.util.encryption.model.Encryption;
import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.subscription.model.Subscription;
import com.adamchilds.daycare.entity.subscription.service.SubscriptionService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping(value={"", "/", "/index"}) // Map these URIs to this controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(ModelMap modelMap) {
        //User user;
        try {
            //user = userService.readUserByEmail("adam.childs@vodori.com");
            String base64 = Encryption.base64Encode("hockey");
            String encrypted = Encryption.encodeString("hockey");
            String sha256 = Encryption.SHA256("hockey");
            modelMap.put("encrypted", encrypted);
            modelMap.put("base64", base64);
            modelMap.put("sha256", sha256);

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
        return new ModelAndView("/index", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postIndex(ModelMap modelMap) {
        //User user;
        try {
            //user = userService.readUserByEmail("adam.childs@vodori.com");
            String base64 = Encryption.base64Encode("hockey");
            String encrypted = Encryption.encodeString("hockey");
            String sha256 = Encryption.SHA256("hockey");
            modelMap.put("encrypted", encrypted);
            modelMap.put("base64", base64);
            modelMap.put("sha256", sha256);

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
        return new ModelAndView("/index");
    }
}
