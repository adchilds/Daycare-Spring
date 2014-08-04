package com.adamchilds.daycare.authentication;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class handles capturing authentication success events and allows for some
 * extra processing afterwards.
 *
 * @author Adam Childs
 * @since 1.0
 */
@Component
public class DaycareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditService auditService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = null;
        try {
            // Set the last login date for the user
            user = userService.readUserByUsername(authentication.getName());
            user.setLastLogin(DateTime.now().toDate());
            userService.update(user);

            // Create an audit for the user login
            auditService.createAuditForLogin(user, true);

            if (logger.isDebugEnabled()) {
                logger.debug("User successfully logged in: USER=[" + user.getUsername() + "]");
            }
        } catch(Exception e) {
            logger.error("An error occurred during authentication success handling... USER=[" + user + "], AUTHENTICATION=[" + authentication.getPrincipal() + "]", e);
        }

        // Continue with normal authentication success behavior
        super.onAuthenticationSuccess(request, response, authentication);
    }

}