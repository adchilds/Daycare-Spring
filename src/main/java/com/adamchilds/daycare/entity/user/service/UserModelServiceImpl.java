package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.dao.UserModelDAO;
import com.adamchilds.daycare.entity.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserModelServiceImpl implements UserModelService {

    @Autowired
    private UserModelDAO userModelDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(User user) {
        userModelDAO.create(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User find(User user) {
        return userModelDAO.find(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return userModelDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User read(Object objectId) {
        return userModelDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsers() {
        return userModelDAO.readAllUsers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsersByAccountId(Long accountId) {
        return userModelDAO.readAllUsersByAccountId(accountId);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserById(Long id) {
        return userModelDAO.readUserById(id);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserByUsername(String username) {
        return userModelDAO.readUserByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserByEmail(String emailAddress) {
        return userModelDAO.readUserByEmail(emailAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(User user) {
        userModelDAO.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(User user) {
        return userModelDAO.update(user);
    }
}