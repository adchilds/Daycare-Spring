package com.adamchilds.daycare.web.pricing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PricingController {

    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public String showDashboardPage(ModelMap model) {
        return "/pricing";
    }
}