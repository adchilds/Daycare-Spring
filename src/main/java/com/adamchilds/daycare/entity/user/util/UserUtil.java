package com.adamchilds.daycare.entity.user.util;

import com.adamchilds.daycare.entity.roles.enumeration.UserRoleEnum;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This utility class contains helpful functions for logged in {@link com.adamchilds.daycare.entity.user.model.User}'s
 * across the site.
 *
 * @author Adam Childs
 * @since 1.0
 */
@Component
public class UserUtil {
    private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);

    @Autowired
    private UserService userService;

    /**
     * Utility method for determining if the current web request is from an
     * authenticated {@link User}.
     *
     * @return true if the current {@link User} is authenticated; false otherwise
     */
    public boolean isUserAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserDetails;
        }

        return false;
    }

    /**
     * Indicates whether or not the current user is an administrator.
     * <p><b>Note:</b><i>Administrators have the roles ROLE_SUPERUSER
     * or ROLE_ADMINISTRATOR</i>
     *
     * @return true if the current user has administrator privileges; false, otherwise.
     */
    public boolean isUserAdministrator() {
        List<String> authorities = getCurrentUserAuthoritiesAsStrings();

        return (authorities.contains(UserRoleEnum.ROLE_ADMINISTRATOR.getRoleText()) ||
                authorities.contains(UserRoleEnum.ROLE_SUPERUSER.getRoleText()));
    }

    /**
     * Retrieves the currently authenticated {@link User}
     *
     * @return the {@link User} specific to the current thread
     */
    public User getCurrentUser() {
        UserDetails userDetails = getCurrentUserDetails();

        if (userDetails != null) {
            if (StringUtils.hasText(userDetails.getUsername())) {
                return userService.readUserByUsername(userDetails.getUsername());
            }
        }

        return null;
    }

    /**
     * Retrieves a list of {@link GrantedAuthority}'s for the currently
     * authenticated {@link User}.
     *
     * @return a new List of {@link GrantedAuthority}'s
     */
    public List<GrantedAuthority> getCurrentUserAuthorities() {
        UserDetails userDetails = getCurrentUserDetails();

        if (userDetails != null) {
            return new ArrayList<>(userDetails.getAuthorities());
        }

        return new ArrayList<>();
    }

    /**
     * Retrieves a list of {@link String}'s that represent the {@link GrantedAuthority}'s
     * of the current user.
     *
     * @return a new List of {@link String}'s of the current user's granted authorities
     */
    public List<String> getCurrentUserAuthoritiesAsStrings() {
        List<GrantedAuthority> authorities = getCurrentUserAuthorities();
        List<String> authoritiesAsStrings = new ArrayList<>();

        for (GrantedAuthority authority : authorities) {
            authoritiesAsStrings.add(authority.getAuthority());
        }

        return authoritiesAsStrings;
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