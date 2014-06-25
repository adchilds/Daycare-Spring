package com.adamchilds.daycare.entity.subscription.dao.impl;

import com.adamchilds.daycare.entity.subscription.dao.SubscriptionDAO;
import com.adamchilds.daycare.entity.subscription.model.Subscription;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class SubscriptionDAOImpl extends AbstractJPADAO implements SubscriptionDAO {

    /**
     * {@inheritDoc}
     */
    public void create(Subscription subscription) {
        super.create(subscription);
    }

    /**
     * {@inheritDoc}
     */
    public Subscription find(Subscription subscription) {
        return super.find(subscription.getClass(), subscription.getId());
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
    public Subscription read(Object objectId) {
        return super.read(Subscription.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllSubscriptions() {
        Query query = super.createNamedQuery( "readAllSubscriptions" );

        return (List<Subscription>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllSubscriptionsByAccountId(Long accountId) {
        Query query = super.createNamedQuery( "readAllSubscriptionsByAccountId" )
                .setParameter("subscriptionAccountId", accountId);

        return (List<Subscription>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllActiveSubscriptions() {
        Query query = super.createNamedQuery( "readAllActiveSubscriptions" );

        return (List<Subscription>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Subscription readActiveSubscriptionByAccountId(Long accountId) {
        Query query = super.createNamedQuery( "readActiveSubscriptionByAccountId" )
                .setParameter("subscriptionAccountId", accountId);

        return (Subscription) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public Subscription readSubscriptionById(Long id) {
        Query query = super.createNamedQuery( "readSubscriptionById" )
                .setParameter("subscriptionId", id);

        return (Subscription) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Subscription subscription) {
        super.remove(subscription);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Subscription subscription) {
        return super.update(subscription);
    }

}