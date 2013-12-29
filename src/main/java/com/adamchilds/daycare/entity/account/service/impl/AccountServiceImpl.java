package com.adamchilds.daycare.entity.account.service.impl;

import com.adamchilds.daycare.entity.account.dao.AccountDAO;
import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Account account) {
        accountDAO.create(account);
    }

    /**
     * {@inheritDoc}
     */
    public Account find(Account account) {
        return accountDAO.find(account);
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return accountDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Account read(Object objectId) {
        return accountDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Account> readAllAccounts() {
        return accountDAO.readAllAccounts();
    }

    /**
     * {@inheritDoc}
     */
    public Account readAccountById(Long id) {
        return accountDAO.readAccountById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Account account) {
        accountDAO.remove(account);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Account account) {
        return accountDAO.update(account);
    }

}