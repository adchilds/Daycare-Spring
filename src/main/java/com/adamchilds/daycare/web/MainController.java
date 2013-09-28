package com.adamchilds.daycare.web;

import com.adamchilds.daycare.encryption.model.Encryption;
import com.adamchilds.daycare.entity.user.enumeration.UserRole;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserModelService;
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
    UserModelService userModelService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showIndex(ModelMap modelMap) {
        //User user;
        try {
            //user = userModelService.readUserByEmail("adam.childs@vodori.com");
            String base64 = Encryption.base64Encode("hockey");
            String encrypted = Encryption.encodeString("hockey");
            modelMap.put("encrypted", encrypted);
            modelMap.put("base64", base64);
            User user = new User();
            user.setAccountId(2);
            user.setEmailAddress("adchilds@eckerd.edu");
            user.setEnabled(true);
            user.setPassword("hockey");
            user.setRole(UserRole.ROLE_ADMINISTRATOR);
            user.setUsername("rinkrat");
            userModelService.create(user);

            ArrayList<User> userList = (ArrayList<User>) userModelService.readAllUsers();
            Random r = new Random();
            modelMap.put("user", userList.get(r.nextInt(userList.size())));
        } catch (NoResultException nre) {
            System.out.println("Query returned no results.");
        }
        return new ModelAndView("/index", modelMap);
    }
}
