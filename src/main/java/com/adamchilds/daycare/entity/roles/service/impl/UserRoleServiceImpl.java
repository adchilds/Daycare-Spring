package com.adamchilds.daycare.entity.roles.service.impl;

import com.adamchilds.daycare.entity.roles.dao.UserRoleDAO;
import com.adamchilds.daycare.entity.roles.model.UserRole;
import com.adamchilds.daycare.entity.roles.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole find(UserRole userRole) {
        return userRoleDAO.find(userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return userRoleDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole read(Object objectId) {
        return userRoleDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserRole> readAllUserRoles() {
        return userRoleDAO.readAllUserRoles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserRole> readAllRolesByUserId(Long userId) {
        return userRoleDAO.readAllRolesByUserId(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole readUserRoleByUserIdAndUserRole(Long userId, String userRole) {
        return userRoleDAO.readUserRoleByUserIdAndUserRole(userId, userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(UserRole userRole) {
        userRoleDAO.remove(userRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(UserRole userRole) {
        return userRoleDAO.update(userRole);
    }

}