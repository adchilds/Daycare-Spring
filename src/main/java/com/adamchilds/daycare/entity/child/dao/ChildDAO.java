package com.adamchilds.daycare.entity.child.dao;

import com.adamchilds.daycare.entity.child.model.Child;

import javax.persistence.EntityManager;
import java.util.List;

public interface ChildDAO {

    /**
     * This method is responsible for creating the {@link com.adamchilds.daycare.entity.child.model.Child}
     *
     * @param child The {@link com.adamchilds.daycare.entity.child.model.Child} to deliver
     */
    public void create(Child child);

    /**
     * Finds the given {@link com.adamchilds.daycare.entity.child.model.Child} in the database.
     *
     * @param child The {@link com.adamchilds.daycare.entity.child.model.Child} to find
     * @return The Child from the database
     */
    public Child find(Child child);

    /**
     * Returns this {@link com.adamchilds.daycare.entity.child.model.Child}'s instance of EntityManager
     * @return an EntityManager tied to this Child instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link com.adamchilds.daycare.entity.child.model.Child} from the database.
     *
     * @param objectId The id of the {@link com.adamchilds.daycare.entity.child.model.Child}
     *                 that we want to retrieve
     * @return The Child from the database
     */
    public Child read(Object objectId);

    /**
     * This method will return a list of all the {@link com.adamchilds.daycare.entity.child.model.Child}'s
     * in the database
     *
     * @return a list of all Childs
     */
    public List<Child> readAllChildren();

    /**
     * Returns a list of all Child(ren) in the database where the given accountId matches
     * that accountId set associated with the Child.
     *
     * @return a List of Child(ren) matching to given criteria
     */
    public List<Child> readAllChildrenByAccountId(Long accountId);

    /**
     * Gets a single {@link com.adamchilds.daycare.entity.child.model.Child}
     * from the DAYCARE_CHILD table by their unique ID
     *
     * @param id the unique id of a valid {@link com.adamchilds.daycare.entity.child.model.Child}
     * @return a single Child based on the given unique ID
     */
    public Child readChildById(Long id);

    /**
     * Removes the specified {@link com.adamchilds.daycare.entity.child.model.Child} from the database.
     *
     * @param child The {@link com.adamchilds.daycare.entity.child.model.Child} to remove
     */
    public void remove(Child child);

    /**
     * Updates the specified {@link com.adamchilds.daycare.entity.child.model.Child} in the database.
     *
     * @param child The {@link com.adamchilds.daycare.entity.child.model.Child} to update
     * @return The {@link com.adamchilds.daycare.entity.child.model.Child} object that has been updated
     */
    public Object update(Child child);

}