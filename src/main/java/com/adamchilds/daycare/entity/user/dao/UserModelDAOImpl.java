package com.adamchilds.daycare.entity.user.dao;

import com.adamchilds.daycare.jpa.AbstractJPADAO;
import com.adamchilds.daycare.entity.user.model.UserModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserModelDAOImpl extends AbstractJPADAO implements UserModelDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(UserModel userModel) {
        super.create(userModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserModel find(UserModel userModel) {
        return super.find(userModel.getClass(), userModel.getId());
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
    public UserModel read(Object objectId) {
        return super.read(UserModel.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserModel> readAllUserModels() {
        Query query = super.createNamedQuery( "readAllUserModels" );

        return (List<UserModel>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(UserModel userModel) {
        super.remove(userModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(UserModel userModel) {
        return super.update(userModel);
    }
}