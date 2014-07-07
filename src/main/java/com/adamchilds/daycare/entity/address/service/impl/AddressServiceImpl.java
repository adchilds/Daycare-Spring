package com.adamchilds.daycare.entity.address.service.impl;

import com.adamchilds.daycare.entity.address.dao.AddressDAO;
import com.adamchilds.daycare.entity.address.model.Address;
import com.adamchilds.daycare.entity.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Address address) {
        addressDAO.create(address);
    }

    /**
     * {@inheritDoc}
     */
    public Address find(Address address) {
        return addressDAO.find(address);
    }

    /**
     * {@inheritDoc}
     */
    public Address read(Object objectId) {
        return addressDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Address> readAllAddresses() {
        return addressDAO.readAllAddresses();
    }

    /**
     * {@inheritDoc}
     */
    public List<Address> readAllAddressesByCity(String city) {
        return addressDAO.readAllAddressesByCity(city);
    }

    /**
     * {@inheritDoc}
     */
    public List<Address> readAllAddressesByCountry(String country) {
        return addressDAO.readAllAddressesByCountry(country);
    }

    /**
     * {@inheritDoc}
     */
    public List<Address> readAllAddressesByState(String state) {
        return addressDAO.readAllAddressesByState(state);
    }

    /**
     * {@inheritDoc}
     */
    public Address readAddressById(Long id) {
        return addressDAO.readAddressById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Address address) {
        addressDAO.remove(address);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Address address) {
        return addressDAO.update(address);
    }

}