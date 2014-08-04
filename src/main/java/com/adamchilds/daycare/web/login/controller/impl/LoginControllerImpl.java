package com.adamchilds.daycare.web.login.controller.impl;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.internationalization.MessageService;
import com.adamchilds.daycare.web.login.LoginConstants;
import com.adamchilds.daycare.web.login.controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class LoginControllerImpl implements LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerImpl.class);

    @Autowired
    private MessageService messageService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLogin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value="error", required=false) String error) {
        modelMap.put("user", new User());

        if (StringUtils.hasText(error)) {

            String errorMessage;
            switch (error) {
                case LoginConstants.ERROR_BAD_CREDENTIALS:
                    errorMessage = messageService.get("login.form.error.bad_credentials");
                    break;

                case LoginConstants.ERROR_EXPIRED_CREDENTIALS:
                    errorMessage = messageService.get("login.form.error.expired_credentials");
                    break;

                case LoginConstants.ERROR_ACCOUNT_DISABLED:
                    errorMessage = messageService.get("login.form.error.account_disabled");
                    break;

                case LoginConstants.ERROR_ACCOUNT_LOCKED:
                    errorMessage = messageService.get("login.form.error.account_locked");
                    break;

                default:
                    errorMessage = messageService.get("login.form.error");

                    logger.error("Unhandled Spring authentication error on user login. error=[" + error + "]");
                    break;
            }

            modelMap.put("error", errorMessage);
        }

        return "login";
    }

}