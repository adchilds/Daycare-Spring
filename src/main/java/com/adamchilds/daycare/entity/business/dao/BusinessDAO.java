package com.adamchilds.daycare.entity.business.dao;

import com.adamchilds.daycare.entity.business.model.Business;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This DAO handles CRUD operations for daycare businesses.
 *
 * @author Adam Childs
 */
public interface BusinessDAO {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.business.model.Business}
     *
     * @param business The {@link com.adamchilds.daycare.entity.business.model.Business} to deliver
     */
    public void create(Business business);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.business.model.Business} in the database.
     *
     * @param business The {@link com.adamchilds.daycare.entity.business.model.Business} to find
     * @return The Business from the database
     */
    public Business find(Business business);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.business.model.Business}'s instance of EntityManager
     * @return an EntityManager tied to this Business instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.business.model.Business} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.business.model.Business}
     *                 that we want to retrieve
     * @return The Business from the database
     */
    public Business read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.business.model.Business}'s
     * in the database
     *
     * @return a list of all Businesses
     */
    public List<Business> readAllBusinesses();

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.business.model.Business}
     * from the DAYCARE_BUSINESS table by the unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.business.model.Business}
     * @return a single Business based on the given unique ID
     */
    public Business readBusinessById(Long id);

    /**
     * Removes the specified {@link com.adamchilds.daycare.entity.business.model.Business} from the database.
     *
     * @param business The {@link com.adamchilds.daycare.entity.business.model.Business} to remove
     */
    public void remove(Business business);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.business.model.Business} in the database.
     *
     * @param business The {@link com.adamchilds.daycare.entity.business.model.Business} to update
     * @return The {@link com.adamchilds.daycare.entity.business.model.Business} object that has been updated
     */
    public Object update(Business business);

}