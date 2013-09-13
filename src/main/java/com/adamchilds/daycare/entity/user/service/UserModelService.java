package com.adamchilds.daycare.entity.user.service;

import com.adamchilds.daycare.entity.user.model.UserModel;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserModelService {

    /**
     * This method is responsible for creating the UserModel
     *
     * @param userModel The userModel to deliver
     */
    public void create(UserModel userModel);

    /**
     * Finds the given UserModel in the database.
     *
     * @param userModel The UserModel to find
     * @return The UserModel from the database
     */
    public UserModel find(UserModel userModel);

    /**
     * Returns this UserModel's instance of EntityManager
     * @return an EntityManager tied to this UserModel instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific UserModel from the database.
     *
     * @param objectId The id of the UserModel that we want to retrieve
     * @return The UserModel from the database
     */
    public UserModel read(Object objectId);

    /**
     * This method will return a list of all the UserModels in the database
     *
     * @return a list of all UserModels
     */
    public List readAllUserModels();

    /**
     * Removes the specified UserModel from the database.
     *
     * @param userModel The UserModel to remove
     */
    public void remove(UserModel userModel);

    /**
     * Updates the specified UserModel in the database.
     *
     * @param userModel The UserModel to update
     * @return The UserModel object that has been updated
     */
    public Object update(UserModel userModel);
}