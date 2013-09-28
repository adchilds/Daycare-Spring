package com.adamchilds.daycare.web;

import com.adamchilds.daycare.encryption.model.Encryption;
import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showIndex(ModelMap modelMap) {
        //User user;
        try {
            //user = userService.readUserByEmail("adam.childs@vodori.com");
            String base64 = Encryption.base64Encode("hockey");
            String encrypted = Encryption.encodeString("hockey");
            modelMap.put("encrypted", encrypted);
            modelMap.put("base64", base64);

            User user = userService.readUserByUsername("adam.childs");
            Account account = accountService.readAccountById(user.getAccountId());
            ArrayList<User> userList = (ArrayList<User>) userService.readAllUsers();
            Random r = new Random();
            modelMap.put("user", userList.get(r.nextInt(userList.size())));
            modelMap.put("account", account);
        } catch (NoResultException nre) {
            System.out.println("Query returned no results.");
        }
        return new ModelAndView("/index", modelMap);
    }
}
