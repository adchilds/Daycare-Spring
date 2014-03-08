package com.adamchilds.daycare.web.pricing.controller;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PricingController {

    @Autowired
    private AuditService auditService;

    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public String showDashboardPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        auditService.createAuditForRequest(request);

        return "/pricing";
    }
}