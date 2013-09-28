package com.adamchilds.daycare.entity.subscription.service;

import com.adamchilds.daycare.entity.subscription.dao.SubscriptionDAO;
import com.adamchilds.daycare.entity.subscription.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Subscription subscription) {
        subscriptionDAO.create(subscription);
    }

    /**
     * {@inheritDoc}
     */
    public Subscription find(Subscription subscription) {
        return subscriptionDAO.find(subscription);
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return subscriptionDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Subscription read(Object objectId) {
        return subscriptionDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllSubscriptions() {
        return subscriptionDAO.readAllSubscriptions();
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllSubscriptionsByAccountId(Long accountId) {
        return subscriptionDAO.readAllSubscriptionsByAccountId(accountId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Subscription> readAllActiveSubscriptions() {
        return subscriptionDAO.readAllActiveSubscriptions();
    }

    /**
     * {@inheritDoc}
     */
    public Subscription readActiveSubscriptionByAccountId(Long accountId) {
        return subscriptionDAO.readActiveSubscriptionByAccountId(accountId);
    }

    /**
     * {@inheritDoc}
     */
    public Subscription readSubscriptionById(Long id) {
        return subscriptionDAO.readSubscriptionById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Subscription subscription) {
        subscriptionDAO.remove(subscription);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Subscription subscription) {
        return subscriptionDAO.update(subscription);
    }

}