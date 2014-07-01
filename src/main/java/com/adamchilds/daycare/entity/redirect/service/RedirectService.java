package com.adamchilds.daycare.entity.redirect.service;

import com.adamchilds.daycare.entity.redirect.model.Redirect;

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
    public void create(Redirect redirect);

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
    public List<Redirect> readAllRedirects();

    /**
     * This method will return an active redirect of one exists for the given URI.
     *
     * @param uri The URI we are looking up.
     * @return The {@link Redirect} if there is one match, NULL if there are no matches.
     */
    public Redirect getRedirect(String uri);

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

}