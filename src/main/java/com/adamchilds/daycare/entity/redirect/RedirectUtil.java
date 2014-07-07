package com.adamchilds.daycare.entity.redirect;

import com.adamchilds.daycare.entity.redirect.model.Redirect;

/**
 * This class contains utility functions and constants useful for site redirects.
 *
 * @author Adam Childs
 */
public class RedirectUtil {

    private static final String REDIRECT_ERROR_URI = "/404.html";

    /*
     * All cache names related to site redirects
     */
    public static final String CACHE_READ_ALL_REDIRECTS = "readAllRedirects";
    public static final String CACHE_READ_REDIRECT_BY_URI = "readRedirectByURI";
    public static final String CACHE_READ_ALL_REDIRECTS_BY_DESTINATION = "readAllRedirectsByDestinationURI";

    /**
     * Creates a new {@link Redirect} object that points to an error page.
     *
     * @return a new {@link Redirect} object pointing to a destination URI that is an error page
     */
    public static Redirect createErrorRedirect() {
        Redirect errorRedirect = new Redirect();
        errorRedirect.setEnabled(true);
        errorRedirect.setDestinationURL(REDIRECT_ERROR_URI);

        return errorRedirect;
    }

}