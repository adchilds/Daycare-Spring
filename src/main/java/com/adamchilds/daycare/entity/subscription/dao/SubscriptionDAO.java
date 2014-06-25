package com.adamchilds.daycare.entity.subscription.dao;

import com.adamchilds.daycare.entity.subscription.model.Subscription;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This DAO handles CRUD operations for subscriptions.
 *
 * @author Adam Childs
 */
public interface SubscriptionDAO {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.subscription.model.Subscription}
     *
     * @param subscription The {@link com.adamchilds.daycare.entity.subscription.model.Subscription} to deliver
     */
    public void create(Subscription subscription);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.subscription.model.Subscription} in the database.
     *
     * @param subscription The {@link com.adamchilds.daycare.entity.subscription.model.Subscription} to find
     * @return The Subscription from the database
     */
    public Subscription find(Subscription subscription);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.subscription.model.Subscription}'s instance of EntityManager
     * @return an EntityManager tied to this Subscription instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.subscription.model.Subscription} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.subscription.model.Subscription}
     *                 that we want to retrieve
     * @return The Subscription from the database
     */
    public Subscription read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.subscription.model.Subscription}'s
     * in the database
     *
     * @return a list of all Subscriptions
     */
    public List<Subscription> readAllSubscriptions();

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.subscription.model.Subscription}'s
     * in the database for the Account with matching accountId
     *
     * @param accountId The accountId of the Account to pull a list of subscriptions for
     * @return a list of all Subscriptions for the Account that matches the given accountId
     */
    public List<Subscription> readAllSubscriptionsByAccountId(Long accountId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.subscription.model.Subscription}'s
     * in the database that are currently active
     *
     * @return a list of all Subscriptions that are currently active
     */
    public List<Subscription> readAllActiveSubscriptions();

    /**
     * This method will return a single {@link com.adamchilds.daycare.entity.subscription.model.Subscription}
     * in the database that is currently active and is for an Account that matches the given accountId
     *
     * @param accountId the accountId of the Account that we want to pull the active subscription for
     * @return a single Subscription that is currently active and related to the given Account with accountId
     */
    public Subscription readActiveSubscriptionByAccountId(Long accountId);

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.subscription.model.Subscription}
     * from the DAYCARE_SUBSCRIPTION table by their unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.subscription.model.Subscription}
     * @return a single Subscription based on the given unique ID
     */
    public Subscription readSubscriptionById(Long id);

    /**
     * Removes the specified {@link com.adamchilds.daycare.entity.subscription.model.Subscription} from the database.
     *
     * @param subscription The {@link com.adamchilds.daycare.entity.subscription.model.Subscription} to remove
     */
    public void remove(Subscription subscription);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.subscription.model.Subscription} in the database.
     *
     * @param subscription The {@link com.adamchilds.daycare.entity.subscription.model.Subscription} to update
     * @return The {@link com.adamchilds.daycare.entity.subscription.model.Subscription} object that has been updated
     */
    public Object update(Subscription subscription);

}