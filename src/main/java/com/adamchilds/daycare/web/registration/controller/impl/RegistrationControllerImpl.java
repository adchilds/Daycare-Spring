package com.adamchilds.daycare.web.registration.controller.impl;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.address.model.Address;
import com.adamchilds.daycare.entity.address.service.AddressService;
import com.adamchilds.daycare.entity.business.model.Business;
import com.adamchilds.daycare.entity.business.service.BusinessService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.registration.controller.RegistrationController;
import com.adamchilds.daycare.web.registration.form.RegistrationForm;
import com.adamchilds.daycare.web.registration.util.RegistrationUtil;
import com.adamchilds.daycare.web.registration.validator.RegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class RegistrationControllerImpl implements RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationControllerImpl.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSignupPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        modelMap.put("registrationForm", new RegistrationForm());
        modelMap.put("selectedPlan", "Premium - $5.00 / month");

        return "registration_index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String submitRegistration(ModelMap modelMap, @ModelAttribute("registrationForm") RegistrationForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        new RegistrationValidator().validate(form, result);

        if (result.hasErrors()) {
            modelMap.addAttribute("errors", "Sorry, an error occurred.");
            return "registration_index";
        }

        // Create and persist the new User to the database
        User user = RegistrationUtil.createUserFromRegistrationForm(form);
        userService.create(user);

        // Create and persist the new Address to the database
        Address address = RegistrationUtil.createAddressFromRegistrationForm(form);
        addressService.create(address);

        // TODO: Is this correct? Need to get the user's ID, but database handles setting it, so I can
        // only get it after persisting them to the database?
        address = addressService.find(address);
        user = userService.find(user);

        // Create and persist the new Account to the database
        Account account = RegistrationUtil.createAccountFromRegistrationForm(form, user, address);
        accountService.create(account);

        // Create and persist the new Business to the database
        Business business = RegistrationUtil.createBusinessFromRegistrationForm(form, user, address);
        businessService.create(business);

        return "index";
    }

}