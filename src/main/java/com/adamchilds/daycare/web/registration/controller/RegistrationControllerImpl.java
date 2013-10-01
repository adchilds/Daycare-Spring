package com.adamchilds.daycare.web.registration.controller;

import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import com.adamchilds.daycare.web.registration.validator.RegistrationValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationControllerImpl implements RegistrationController {

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView getSignupPage(ModelMap modelMap) {
        modelMap.put("registrationForm", new RegistrationForm());
        return new ModelAndView("/signup");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView submitRegistration(ModelMap modelMap,
                           @ModelAttribute("registrationForm") RegistrationForm form,
                           BindingResult result) {
        new RegistrationValidator().validate(form, result);

        if (result.hasErrors()) {
            return new ModelAndView("/signup", modelMap);
        }
        return new ModelAndView("/index", modelMap);
    }
}