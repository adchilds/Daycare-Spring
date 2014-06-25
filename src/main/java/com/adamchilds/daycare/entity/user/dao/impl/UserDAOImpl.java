package com.adamchilds.daycare.entity.user.dao.impl;

import com.adamchilds.daycare.entity.user.dao.UserDAO;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDAOImpl extends AbstractJPADAO implements UserDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(User user) {
        User existingUser = readUserByUsername(user.getUsername());
        if (existingUser == null) {
            super.create(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User find(User user) {
        return super.find(user.getClass(), user.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User read(Object objectId) {
        return super.read(User.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsers() {
        Query query = super.createNamedQuery( "readAllUsers" );

        return (List<User>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsersByAccountId(Long accountId) {
        Query query = super.createNamedQuery( "readAllUsersByAccountId")
                .setParameter("userAccountId", accountId);

        return (List<User>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User readUserById(Long id) {
        Query query = super.createNamedQuery( "readUserById" )
                .setParameter("userId", id);

        return (User) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User readUserByUsername(String username) {
        Query query = super.createNamedQuery( "readUserByUsername" )
                .setParameter("userName", username);

        return (User) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User readUserByEmail(String emailAddress) {
        Query query = super.createNamedQuery( "readUserByEmail" )
                .setParameter("userEmail", emailAddress);

        return (User) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(User user) {
        super.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(User user) {
        return super.update(user);
    }
}