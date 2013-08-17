package com.adamchilds.daycare.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello.html") // Map this class to the "hello.html" page
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHelloPage(ModelMap model) {
        // Adds the given key/value combinations to a map which can
        // then be used in the *.jsp file from JSTL tags (i.e. ${name} )
        model.put("name", "Adam");

        return new ModelAndView("/index", model);
    }
}
