package com.adamchilds.daycare.filter;

import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.entity.redirect.service.RedirectService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Filter to redirect requests before hitting the application when a custom redirect is in place. To include, update
 * your web.xml with the following lines:
 *
 * <filter>
 *     <filter-name>redirectFilter</filter-name>
 *     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
 * </filter>
 *
 * <filter-mapping>
 *     <filter-name>redirectFilter</filter-name>
 *     <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
@Component
public class RedirectFilter extends GenericFilterBean {

    @Autowired
    private RedirectService redirectService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        // Check to see if the specified URI requires a redirect
        Redirect redirect = redirectService.readRedirectByURI(uri);

        if (redirect != null) {
            Calendar startDate = redirect.getStartDate();
            Calendar endDate = redirect.getEndDate();

            boolean shouldRedirect = true;

            // If the redirect has a start date
            if (startDate != null) {

                // If the current date is after the start date, redirect
                shouldRedirect = DateTime.now().isAfter(startDate.getTimeInMillis());
            }

            // Only check the endDate if the startDate hasn't already failed
            if (shouldRedirect) {

                // If the redirect has an end date
                if (endDate != null) {

                    // If the current date is before the end date, redirect
                    shouldRedirect = DateTime.now().isBefore(endDate.getTimeInMillis());
                }
            }

            if (shouldRedirect) {
                if (redirect.isEnabled()) {
                    // Get the destinationURI of the current request URI if one exists
                    String destinationURI = redirect.getDestinationURL();

                    // If a destination URI exists for the current request URI, redirect the user
                    if (StringUtils.hasText(destinationURI)) {
                        httpServletResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                        httpServletResponse.sendRedirect(destinationURI);
                    }
                } else {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Redirect is disabled for URI=[" + uri + "]");
                    }

                    chain.doFilter(request, response);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("Redirect is not active. startDate=[" + startDate + "], endDate=[" + endDate + "]");
                }

                chain.doFilter(request, response);
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("No redirect found for the current request. requestURI=[" + uri + "]");
            }

            chain.doFilter(request, response);
        }
    }

}