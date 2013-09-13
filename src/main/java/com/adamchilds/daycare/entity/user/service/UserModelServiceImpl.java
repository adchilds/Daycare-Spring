package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.dao.UserModelDAO;
import com.adamchilds.daycare.entity.user.model.UserModel;
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
    public void create(UserModel userModel) {
        userModelDAO.create(userModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserModel find(UserModel userModel) {
        return userModelDAO.find(userModel);
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
    public UserModel read(Object objectId) {
        return userModelDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List readAllUserModels() {
        return userModelDAO.readAllUserModels();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(UserModel userModel) {
        userModelDAO.remove(userModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(UserModel userModel) {
        return userModelDAO.update(userModel);
    }
}