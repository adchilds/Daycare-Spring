package com.adamchilds.daycare.entity.redirect.service;

import com.adamchilds.daycare.entity.redirect.RedirectUtil;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Enables implementers to persist information about site redirects.
 *
 * <p>{@link Redirect}s contain information such as the source URL and destination URL for a site redirect.
 *
 * <p>A global interceptor can capture all requests and match the current request against any redirects
 * that have been persisted to the database. If one is matched against the given source URL, the user will be
 * redirected to the destination URL.
 *
 * <p>Likewise and in the case of this redirector, a Spring filter can be used to capture requests and redirect users if
 * a redirect exists for the given requested URI.
 *
 * @author Adam Childs
 */
public interface RedirectService {

    /**
     * This method is responsible for creating the {@link Redirect}
     *
     * @param redirect The {@link Redirect} to persist
     */
    public Redirect create(Redirect redirect);

    /**
     * Finds the given {@link Redirect} in the database.
     *
     * @param redirect The {@link Redirect} to find
     * @return The matching {@link Redirect} from the database
     */
    public Redirect find(Redirect redirect);

    /**
     * Return a specific {@link Redirect} from the database.
     *
     * @param objectId The id of the {@link Redirect} that we want to retrieve
     * @return The matching {@link Redirect} from the database
     */
    public Redirect read(Object objectId);

    /**
     * This method will return a list of all the {@link Redirect}s in the database
     *
     * @return a list of all {@link Redirect}s
     */
    @Cacheable(value = RedirectUtil.CACHE_READ_ALL_REDIRECTS)
    public List<Redirect> readAllRedirects();

    /**
     * This method will return a list of all {@link Redirect}s that have a destination URI of the value specified.
     *
     * @param destinationURI the destination URI that the redirect must contain in order to be returned
     * @return a list of all {@link Redirect}s with the given destination URI
     */
    @Cacheable(value = RedirectUtil.CACHE_READ_ALL_REDIRECTS_BY_DESTINATION, key="#destinationURI")
    public List<Redirect> readAllRedirectsByDestinationURI(String destinationURI);

    /**
     * This method will return an active redirect if one exists for the given URI.
     *
     * @param uri The URI we are looking up.
     * @return The {@link Redirect} if there is one match, NULL if there are no matches.
     */
    @Cacheable(value = RedirectUtil.CACHE_READ_REDIRECT_BY_URI, key = "#uri")
    public Redirect readRedirectByURI(String uri);

    /**
     * Removes the specified {@link Redirect} from the database.
     *
     * @param redirect The {@link Redirect} to remove
     */
    public void remove(Redirect redirect);

    /**
     * Updates the specified {@link Redirect} in the database.
     *
     * @param redirect The {@link Redirect} to update
     */
    public void update(Redirect redirect);

    /**
     * Clears all entries from the internal redirect cache.
     */
    public void clearRedirectCache();

}