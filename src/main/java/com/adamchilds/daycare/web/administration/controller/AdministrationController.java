package com.adamchilds.daycare.web.administration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface AdministrationController {

    @RequestMapping(value="/administration/index")
    public ModelAndView getAdmin(ModelMap modelMap);
}