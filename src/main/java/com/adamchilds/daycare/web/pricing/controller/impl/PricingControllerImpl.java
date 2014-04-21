package com.adamchilds.daycare.web.pricing.controller.impl;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.web.pricing.controller.PricingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class PricingControllerImpl implements PricingController {
    private static final Logger logger = LoggerFactory.getLogger(PricingControllerImpl.class);

    @Autowired
    private AuditService auditService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPricingPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "pricing";
    }

}