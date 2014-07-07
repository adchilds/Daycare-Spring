package com.adamchilds.daycare.entity.guardian.service;

import com.adamchilds.daycare.entity.guardian.model.Guardian;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This service provides functionality for interfacing with daycare guardians.
 *
 * @author Adam Childs
 */
public interface GuardianService {

    /**
     * This method is responsible for creating the {@link Guardian}
     *
     * @param guardian The {@link Guardian} to deliver
     * @return the {@link Guardian} object that was persisted to the database
     */
    public Object create(Guardian guardian);

    /**
     * Finds the given {@link Guardian} in the database.
     *
     * @param guardian The {@link Guardian} to find
     * @return The Guardian from the database
     */
    public Guardian find(Guardian guardian);

    /**
     * Return a specific {@link Guardian} from the database.
     *
     * @param objectId The id of the {@link Guardian}
     *                 that we want to retrieve
     * @return The Guardian from the database
     */
    public Guardian read(Object objectId);

    /**
     * This method will return a list of all the {@link Guardian}'s in the database
     *
     * @return a list of all Guardian
     */
    public List<Guardian> readAllGuardians();

    /**
     * This method will return a list of all the {@link Guardian}s with a last name matching the given {@code lastName}
     *
     * @param lastName the last name that the {@link Guardian} must have to be returned as a result
     * @return a list of {@link Guardian}s with the given {@code lastName}
     */
    public List<Guardian> readAllGuardiansByLastName(String lastName);

    /**
     * Gets a single {@link Guardian} from the DAYCARE_GUARDIAN table by their unique ID
     *
     * @param id the unique id of a valid {@link Guardian}
     * @return a single Guardian based on the given unique ID
     */
    @Cacheable(value="readGuardianById", key="#id")
    public Guardian readGuardianById(Long id);

    /**
     * Removes the specified {@link Guardian} from the database.
     *
     * @param guardian The {@link Guardian} to remove
     */
    public void remove(Guardian guardian);

    /**
     * Updates the specified {@link Guardian} in the database.
     *
     * @param guardian The {@link Guardian} to update
     * @return The {@link Guardian} object that has been updated
     */
    public Guardian update(Guardian guardian);

}