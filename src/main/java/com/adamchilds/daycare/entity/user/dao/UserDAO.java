package com.adamchilds.daycare.entity.user.dao;

import com.adamchilds.daycare.entity.user.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDAO {

    /**
     * Persists a User to the database.
     *
     * @param user The User to save
     */
    public void create(User user);

    /**
     * Finds the given User in the database
     *
     * @param user The User to find
     */
    public User find(User user);

    /**
     * Returns this User's instance of EntityManager
     * @return an EntityManager tied to this User instance
     */
    public EntityManager getEntityManager();

    /**
     * Gathers a list of all Users from the database.
     *
     * @return A list of all Users
     */
    public List<User> readAllUsers();

    /**
     * Reads all {@link com.adamchilds.daycare.entity.user.model.User}'s from the database that are
     * associated with the specified accountId
     *
     * @param accountId the accountId set on the User accounts we want to find
     * @return a List of {@link com.adamchilds.daycare.entity.user.model.User}'s with accountId's matching the
     *      specified accountId
     */
    public List<User> readAllUsersByAccountId(Long accountId);

    /**
     * Gets a single User from the DAYCARE_USER table by their unique ID
     *
     * @param id the unique Id of the user to find
     * @return a single User based on the given unique ID
     */
    public User readUserById(Long id);

    /**
     * Gets a single User from the DAYCARE_USER table by their username
     *
     * @param username the username of the User to find
     * @return a single User based on the given username
     */
    public User readUserByUsername(String username);

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.user.model.User}
     * from the DAYCARE_USER table by their email address
     *
     * @param emailAddress the email address of a valid {@link com.adamchilds.daycare.entity.user.model.User}
     * @return a {@link com.adamchilds.daycare.entity.user.model.User}
     */
    public User readUserByEmail(String emailAddress);

    /**
     * Return a specific User from the database.
     *
     * @param objectId The if of the User that we want to retrieve
     * @return The User from the database
     */
    public User read(Object objectId);

    /**
     * Removes the given User from the database.
     *
     * @param user The User to remove
     */
    public void remove(User user);

    /**
     * Updates a specific User in the database.
     *
     * @param user The User to update
     * @return The User object that has been updated
     */
    public Object update(User user);
}