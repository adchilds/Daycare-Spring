package com.adamchilds.daycare.entity.account.service;

import com.adamchilds.daycare.entity.account.model.Account;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This service provides functionality for interfacing with users accounts.
 *
 * @author Adam Childs
 */
public interface AccountService {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.account.model.Account}
     *
     * @param account The {@link com.adamchilds.daycare.entity.account.model.Account} to deliver
     */
    public void create(Account account);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.account.model.Account} in the database.
     *
     * @param account The {@link com.adamchilds.daycare.entity.account.model.Account} to find
     * @return The Account from the database
     */
    public Account find(Account account);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.account.model.Account}'s instance of EntityManager
     * @return an EntityManager tied to this Account instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.account.model.Account} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.account.model.Account}
     *                 that we want to retrieve
     * @return The Account from the database
     */
    public Account read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.account.model.Account}'s
     * in the database
     *
     * @return a list of all Accounts
     */
    public List<Account> readAllAccounts();

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.account.model.Account}
     * from the DAYCARE_ACCOUNT table by their unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.account.model.Account}
     * @return a single Account based on the given unique ID
     */
    public Account readAccountById(Long id);

    /**
     * Removes the specified {@link com.adamchilds.daycare.entity.account.model.Account} from the database.
     *
     * @param account The {@link com.adamchilds.daycare.entity.account.model.Account} to remove
     */
    public void remove(Account account);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.account.model.Account} in the database.
     *
     * @param account The {@link com.adamchilds.daycare.entity.account.model.Account} to update
     * @return The {@link com.adamchilds.daycare.entity.account.model.Account} object that has been updated
     */
    public Object update(Account account);

}