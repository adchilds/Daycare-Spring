package com.adamchilds.daycare.entity.redirect.dao;

import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.entity.redirect.service.RedirectService;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Enables implementers of the {@link RedirectService} to persist information about site redirects.
 *
 * <p>{@link Redirect}s contain information such as the source URL and destination URL for a site redirect.
 *
 * <p>A global interceptor can capture all requests and match the current request against any redirects
 * that have been persisted to the database. If one is matched against the given source URL, the user will be
 * redirected to the destination URL.
 *
 * <p><b>Note:</b> <i>This DAO should not be used directly. Consider using the {@link RedirectService}.</i>
 *
 * @author Adam Childs
 */
public interface RedirectDAO {

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
     * Finds an active, enabled {@link Redirect} object for a given request URI.
     *
     * @param requestURI The URI to match
     * @throws DataIntegrityViolationException if more than one valid redirect matches the query
     */
    public Redirect readRedirectByURI(String requestURI) throws DataIntegrityViolationException;

    /**
     * This method will return a list of all the {@link Redirect}s in the database
     *
     * @return a list of all {@link Redirect}s
     */
    public List<Redirect> readAllRedirects();

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