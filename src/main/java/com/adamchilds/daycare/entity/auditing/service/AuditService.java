package com.adamchilds.daycare.entity.auditing.service;

import com.adamchilds.daycare.entity.auditing.enumeration.AuditTypeEnum;
import com.adamchilds.daycare.entity.auditing.model.Audit;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This interface defines methods that must be implemented in an implementing class
 * when dealing with auditing user interaction with the website.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface AuditService {

    /**
     * This method is responsible for creating the {@link Audit}
     *
     * @param audit The {@link Audit} to deliver
     */
    public void create(Audit audit);

    /**
     * Creates a new {@link Audit} and persists it to the database for a web request.
     *
     * @param request the web request being handled
     */
    public void createAuditForRequest(HttpServletRequest request);

    /**
     * Finds the given {@link Audit} in the database.
     *
     * @param audit The {@link Audit} to find
     * @return The Audit from the database
     */
    public Audit find(Audit audit);

    /**
     * Returns this {@link Audit}'s instance of EntityManager
     * @return an EntityManager tied to this Audit instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link Audit} from the database.
     *
     * @param objectId The id of the {@link Audit} that we want to retrieve
     * @return The Audit from the database
     */
    public Audit read(Object objectId);

    /**
     * This method will return a list of all the {@link Audit}'s in the database
     *
     * @return a list of all Audits
     */
    public List<Audit> readAllAudits();

    /**
     * Reads a List of Audits from the database that have a matching value in the AUDIT_TYPE column
     * to the {@code auditTypeEnum} value supplied.
     *
     * @param auditTypeEnum the audits with type to pull from the database
     * @return a list of {@link Audit}s with an auditType matching the supplied {@link AuditTypeEnum} value
     */
    public List<Audit> readAllAuditsByType(AuditTypeEnum auditTypeEnum);

    /**
     * Reads a List of {@link Audit}s from the database for the given {@link com.adamchilds.daycare.entity.user.model.User}
     * by the ID of said User.
     *
     * @param userId the ID of the {@link com.adamchilds.daycare.entity.user.model.User} to get a list of {@link Audit}s for
     * @return a List of {@link Audit}s for the given User with ID
     */
    public List<Audit> readAllAuditsByUserId(Long userId);

    /**
     * Gets a single {@link Audit} from the DAYCARE_AUDIT table by the unique ID
     *
     * @param id the unique ID of a valid {@link Audit}
     * @return a single Audit based on the given unique ID
     */
    public Audit readAuditById(Long id);

    /**
     * Removes the specified {@link Audit} from the database.
     *
     * @param audit The {@link Audit} to remove
     */
    public void remove(Audit audit);

    /**
     * Updates the specified {@link Audit} in the database.
     *
     * @param audit The {@link Audit} to update
     * @return The {@link Audit} object that has been updated
     */
    public Object update(Audit audit);

}