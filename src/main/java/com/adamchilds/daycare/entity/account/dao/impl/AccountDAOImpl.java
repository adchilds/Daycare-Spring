package com.adamchilds.daycare.entity.account.dao.impl;

import com.adamchilds.daycare.entity.account.dao.AccountDAO;
import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountDAOImpl extends AbstractJPADAO implements AccountDAO {

    /**
     * {@inheritDoc}
     */
    public void create(Account account) {
        super.create(account);
    }

    /**
     * {@inheritDoc}
     */
    public Account find(Account account) {
        return super.find(account.getClass(), account.getId());
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
    public Account read(Object objectId) {
        return super.read(Account.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Account> readAllAccounts() {
        Query query = super.createNamedQuery( "readAllAccounts" );

        return (List<Account>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Account readAccountById(Long id) {
        Query query = super.createNamedQuery( "readAccountById" )
                .setParameter("accountId", id);

        return (Account) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Account account) {
        super.remove(account);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Account account) {
        return super.update(account);
    }

}