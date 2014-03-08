package com.adamchilds.daycare.web.legal.controller.impl;

import com.adamchilds.daycare.web.legal.controller.LegalController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class LegalControllerImpl implements LegalController {
    private static final Logger logger = LoggerFactory.getLogger(LegalControllerImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTermsOfService(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "terms_of_service";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPrivacyPolicy(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "privacy_policy";
    }

}