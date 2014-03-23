package com.adamchilds.daycare.entity.roles.dao.impl;

import com.adamchilds.daycare.entity.roles.dao.UserRoleDAO;
import com.adamchilds.daycare.entity.roles.model.UserRole;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserRoleDAOImpl extends AbstractJPADAO implements UserRoleDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(UserRole userRole) {
        UserRole existingUserRole = readUserRoleByUserIdAndUserRole(userRole.getUserId(), userRole.getRole());
        if (existingUserRole == null) {
            super.create(userRole);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole find(UserRole userRole) {
        return super.find(userRole.getClass(), userRole.getId());
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
    public UserRole read(Object objectId) {
        return super.read(UserRole.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserRole> readAllUserRoles() {
        Query query = super.createNamedQuery( "readAllUserRoles" );

        return (List<UserRole>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserRole> readAllRolesByUserId(Long userId) {
        Query query = super.createNamedQuery( "readAllRolesByUserId")
                .setParameter("userId", userId);

        return (List<UserRole>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole readUserRoleByUserIdAndUserRole(Long userId, String userRole) {
        Query query = super.createNamedQuery( "readUserRoleByUserIdAndUserRole")
                .setParameter("userId", userId)
                .setParameter("userRole", userRole);

        try {
            return (UserRole) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(UserRole userRole) {
        super.remove(userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(UserRole userRole) {
        return super.update(userRole);
    }

}