package com.adamchilds.daycare.entity.business.service.impl;

import com.adamchilds.daycare.entity.business.dao.BusinessDAO;
import com.adamchilds.daycare.entity.business.model.Business;
import com.adamchilds.daycare.entity.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDAO businessDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Business business) {
        businessDAO.create(business);
    }

    /**
     * {@inheritDoc}
     */
    public Business find(Business business) {
        return businessDAO.find(business);
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return businessDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Business read(Object objectId) {
        return businessDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Business> readAllBusinesses() {
        return businessDAO.readAllBusinesses();
    }

    /**
     * {@inheritDoc}
     */
    public Business readBusinessById(Long id) {
        return businessDAO.readBusinessById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Business business) {
        businessDAO.remove(business);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Business business) {
        return businessDAO.update(business);
    }

}