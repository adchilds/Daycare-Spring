package com.adamchilds.daycare.web;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.util.encryption.EncryptionUtil;
import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.subscription.model.Subscription;
import com.adamchilds.daycare.entity.subscription.service.SubscriptionService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.login.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping(value={"", "/", "/index"}) // Map these URIs to this controller
public class MainController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AuditService auditService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        auditService.createAuditForRequest(request);

        modelMap.put("loginForm", new LoginForm());

        return new ModelAndView("/index", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postIndex(@ModelAttribute("loginForm") LoginForm loginForm, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        auditService.createAuditForRequest(request);

        //User user;
        try {
            //user = userService.readUserByEmail("adam.childs@vodori.com");
            String base64 = EncryptionUtil.base64Encode("hockey");
            String encrypted = EncryptionUtil.encodeString("hockey");
            String sha256 = EncryptionUtil.SHA256("hockey");
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
            modelMap.put("loginForm", new LoginForm());
        } catch (NoResultException nre) {
            System.out.println("Query returned no results.");
        }
        return new ModelAndView("/index");
    }
}
