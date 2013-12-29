package com.adamchilds.daycare.entity.business.dao.impl;

import com.adamchilds.daycare.entity.business.dao.BusinessDAO;
import com.adamchilds.daycare.entity.business.model.Business;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BusinessDAOImpl extends AbstractJPADAO implements BusinessDAO {

    /**
     * {@inheritDoc}
     */
    public void create(Business business) {
        super.create(business);
    }

    /**
     * {@inheritDoc}
     */
    public Business find(Business business) {
        return super.find(business.getClass(), business.getBusinessId());
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Business read(Object objectId) {
        return super.read(Business.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Business> readAllBusinesses() {
        Query query = super.createNamedQuery( "readAllBusinesses" );

        return (List<Business>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Business readBusinessById(Long id) {
        Query query = super.createNamedQuery( "readBusinessById" )
                .setParameter("businessId", id);

        return (Business) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Business business) {
        super.remove(business);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Business business) {
        return super.update(business);
    }

}