package com.adamchilds.daycare.entity.address.dao.impl;

import com.adamchilds.daycare.entity.address.dao.AddressDAO;
import com.adamchilds.daycare.entity.address.model.Address;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class AddressDAOImpl extends AbstractJPADAO implements AddressDAO {

    /**
     * {@inheritDoc}
     */
    public void create(Address address) {
        super.create(address);
    }

    /**
     * {@inheritDoc}
     */
    public Address find(Address address) {
        return super.find(address.getClass(), address.getAddressId());
    }

    /**
     * {@inheritDoc}
     */
    public Address read(Object objectId) {
        return super.read(Address.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Address> readAllAddresses() {
        Query query = super.createNamedQuery( "readAllAddresses" );

        return (List<Address>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Address> readAllAddressesByCity(String city) {
        Query query = super.createNamedQuery( "readAllAddressesByCity" )
                .setParameter("addressCity", city);

        return (List<Address>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Address> readAllAddressesByCountry(String country) {
        Query query = super.createNamedQuery( "readAllAddressesByCountry" )
                .setParameter("addressCountry", country);

        return (List<Address>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Address> readAllAddressesByState(String state) {
        Query query = super.createNamedQuery( "readAllAddressesByState" )
                .setParameter("addressState", state);

        return (List<Address>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Address readAddressById(Long id) {
        Query query = super.createNamedQuery( "readAddressById" )
                .setParameter("addressId", id);

        return (Address) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Address address) {
        super.remove(address);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Address address) {
        return super.update(address);
    }

}