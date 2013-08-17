package com.adamchilds.daycare.user.dao;

import com.adamchilds.daycare.user.model.UserModel;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserModelDAO {

    /**
     * Persists a UserModel to the database.
     *
     * @param userModel The UserModel to save
     */
    public void create(UserModel userModel);

    /**
     * Finds the given UserModel in the database
     *
     * @param userModel The UserModel to find
     */
    public UserModel find(UserModel userModel);

    /**
     * Returns this UserModel's instance of EntityManager
     * @return an EntityManager tied to this UserModel instance
     */
    public EntityManager getEntityManager();

    /**
     * Gathers a list of all UserModels from the database.
     *
     * @return A list of all UserModels
     */
    public List<UserModel> readAllUserModels();

    /**
     * Return a specific UserModel from the database.
     *
     * @param objectId The if of the UserModel that we want to retrieve
     * @return The UserModel from the database
     */
    public UserModel read(Object objectId);

    /**
     * Removes the given UserModel from the database.
     *
     * @param userModel The UserModel to remove
     */
    public void remove(UserModel userModel);

    /**
     * Updates a specific UserModel in the database.
     *
     * @param userModel The UserModel to update
     * @return The UserModel object that has been updated
     */
    public Object update(UserModel userModel);
}