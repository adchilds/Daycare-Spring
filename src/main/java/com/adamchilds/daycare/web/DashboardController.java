package com.adamchilds.daycare.web;

import com.adamchilds.daycare.entity.user.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboardPage(ModelMap model) {
        System.out.println("In dashboard controller: " + model);

        UserModel u = (UserModel)model.get("user");

        System.out.println("In dashboard controller: " + u);

        return "/dashboard";
    }
}