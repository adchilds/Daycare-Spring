package com.adamchilds.daycare.web.administration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrationController {

    @RequestMapping(value="/administration/index")
    public ModelAndView getAdmin(ModelMap modelMap) {
        return new ModelAndView("/administration/index");
    }
}