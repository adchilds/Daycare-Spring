package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.dao.UserDAO;
import com.adamchilds.daycare.entity.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User find(User user) {
        return userDAO.find(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return userDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User read(Object objectId) {
        return userDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsers() {
        return userDAO.readAllUsers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> readAllUsersByAccountId(Long accountId) {
        return userDAO.readAllUsersByAccountId(accountId);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserById(Long id) {
        return userDAO.readUserById(id);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserByUsername(String username) {
        return userDAO.readUserByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    public User readUserByEmail(String emailAddress) {
        return userDAO.readUserByEmail(emailAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(User user) {
        userDAO.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(User user) {
        return userDAO.update(user);
    }
}