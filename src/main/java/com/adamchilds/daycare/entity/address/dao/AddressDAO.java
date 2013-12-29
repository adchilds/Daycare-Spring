package com.adamchilds.daycare.entity.address.dao;

import com.adamchilds.daycare.entity.address.model.Address;

import javax.persistence.EntityManager;
import java.util.List;

public interface AddressDAO {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.address.model.Address}
     *
     * @param address The {@link com.adamchilds.daycare.entity.address.model.Address} to deliver
     */
    public void create(Address address);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.address.model.Address} in the database.
     *
     * @param address The {@link com.adamchilds.daycare.entity.address.model.Address} to find
     * @return The Address from the database
     */
    public Address find(Address address);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.address.model.Address}'s instance of EntityManager
     * @return an EntityManager tied to this Address instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.address.model.Address} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.address.model.Address}
     *                 that we want to retrieve
     * @return The Account from the database
     */
    public Address read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.address.model.Address}'s
     * in the database
     *
     * @return a list of all Addresses
     */
    public List<Address> readAllAddresses();

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.address.model.Address}
     * from the ADDRESS table by the unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.address.model.Address}
     * @return a single Address based on the given unique ID
     */
    public Address readAddressById(Long id);

    /**
     * Removes the specified {@link com.adamchilds.daycare.entity.address.model.Address} from the database.
     *
     * @param address The {@link com.adamchilds.daycare.entity.address.model.Address} to remove
     */
    public void remove(Address address);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.address.model.Address} in the database.
     *
     * @param address The {@link com.adamchilds.daycare.entity.address.model.Address} to update
     * @return The {@link com.adamchilds.daycare.entity.address.model.Address} object that has been updated
     */
    public Object update(Address address);

}