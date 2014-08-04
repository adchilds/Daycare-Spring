package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This service provides functionality for interfacing with users.
 *
 * @author Adam Childs
 */
public interface UserService {

    /**
     * This method is responsible for creating the {@link User}
     *
     * @param user The {@link User} to deliver
     */
    public void create(User user);

    /**
     * Finds the given {@link User} in the database.
     *
     * @param user The {@link User} to find
     * @return The User from the database
     */
    public User find(User user);

    /**
     * Returns this {@link User}'s instance of EntityManager
     * @return an EntityManager tied to this User instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link User} from the database.
     *
     * @param objectId The id of the {@link User} that we want to retrieve
     * @return The User from the database
     */
    public User read(Object objectId);

    /**
     * This method will return a list of all the {@link User}'s
     * in the database
     *
     * @return a list of all Users
     */
    public List<User> readAllUsers();

    /**
     * Reads all {@link User}'s from the database that are
     * associated with the specified accountId
     *
     * @param accountId the accountId set on the User accounts we want to find
     * @return a List of {@link User}'s with accountId's matching the
     *      specified accountId
     */
    public List<User> readAllUsersByAccountId(Long accountId);

    /**
     * Gets a single {@link User}
     * from the DAYCARE_USER table by their unique ID
     *
     * @param id the unique id of a valid {@link User}
     * @return a single User based on the given unique ID
     */
    public User readUserById(Long id);

    /**
     * Gets a single {@link User}
     * from the DAYCARE_USER table by their username
     *
     * @param username the username of a valid {@link User}
     * @return a {@link User}
     */
    public User readUserByUsername(String username);

    /**
     * Gets a single {@link User}
     * from the DAYCARE_USER table by their email address
     *
     * @param emailAddress the email address of a valid {@link User}
     * @return a {@link User}
     */
    public User readUserByEmail(String emailAddress);

    /**
     * Removes the specified {@link User} from the database.
     *
     * @param user The {@link User} to remove
     */
    public void remove(User user);

    /**
     * Updates the specified {@link User} in the database.
     *
     * @param user The {@link User} to update
     * @return The {@link User} object that has been updated
     */
    public Object update(User user);

}