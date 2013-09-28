package com.adamchilds.daycare.web;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping(value={"", "/", "/index"}) // Map these URIs to this controller
public class MainController {

    @Autowired
    UserModelService userModelService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showIndex(ModelMap modelMap) {
        User user = userModelService.readUserByEmail("adam.childs@vodori.com");
        modelMap.put("user", user);

        return new ModelAndView("/index", modelMap);
    }
}
