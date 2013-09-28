package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserModelService {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.user.model.User}
     *
     * @param user The {@link com.adamchilds.daycare.entity.user.model.User} to deliver
     */
    public void create(User user);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.user.model.User} in the database.
     *
     * @param user The {@link com.adamchilds.daycare.entity.user.model.User} to find
     * @return The User from the database
     */
    public User find(User user);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.user.model.User}'s instance of EntityManager
     * @return an EntityManager tied to this User instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.user.model.User} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.user.model.User}
     *                 that we want to retrieve
     * @return The User from the database
     */
    public User read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.user.model.User}'s
     * in the database
     *
     * @return a list of all Users
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
     * Gets a single {@link com.adamchilds.daycare.entity.user.model.User}
     * from the DAYCARE_USER table by their unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.user.model.User}
     * @return a single User based on the given unique ID
     */
    public User readUserById(Long id);

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.user.model.User}
     * from the DAYCARE_USER table by their username
     *
     * @param username the username of a valid {@link com.adamchilds.daycare.entity.user.model.User}
     * @return a {@link com.adamchilds.daycare.entity.user.model.User}
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
     * Removes the specified {@link com.adamchilds.daycare.entity.user.model.User} from the database.
     *
     * @param user The {@link com.adamchilds.daycare.entity.user.model.User} to remove
     */
    public void remove(User user);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.user.model.User} in the database.
     *
     * @param user The {@link com.adamchilds.daycare.entity.user.model.User} to update
     * @return The {@link com.adamchilds.daycare.entity.user.model.User} object that has been updated
     */
    public Object update(User user);
}