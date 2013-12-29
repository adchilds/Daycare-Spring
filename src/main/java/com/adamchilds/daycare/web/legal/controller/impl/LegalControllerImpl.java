package com.adamchilds.daycare.web.legal.controller.impl;

import com.adamchilds.daycare.web.legal.controller.LegalController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller("legalController")
public class LegalControllerImpl implements LegalController {

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView getTermsOfService(ModelMap modelMap) {
        return new ModelAndView("/legal/tos", modelMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView getPrivacyPolicy(ModelMap modelMap) {
        return new ModelAndView("/legal/privacy", modelMap);
    }

}