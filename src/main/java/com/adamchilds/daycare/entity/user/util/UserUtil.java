package com.adamchilds.daycare.entity.user.util;

import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserUtil {
    private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);

    @Autowired
    private UserService userService;

    public boolean isUserAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserDetails;
        }

        return false;
    }

    public User getCurrentUser() {
        UserDetails userDetails = getCurrentUserDetails();

        if (userDetails != null) {
            if (StringUtils.hasText(userDetails.getUsername())) {
                return userService.readUserByUsername(userDetails.getUsername());
            }
        }

        return null;
    }

    private UserDetails getCurrentUserDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserDetails ? (UserDetails) principal : null;
        }
        return null;
    }

}