package com.adamchilds.daycare.jpa;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Base DAO for working with {@link EntityManager} to do basic
 * CRUD (create, read, update, delete) operations on entities.
 */
@Transactional(value = "transactionManager")
public abstract class AbstractJPADAO {

    @PersistenceContext(unitName = "daycare")
    protected EntityManager entityManager;

    /**
     * Persists an object to the database
     *
     * @param obj The object to save
     */
    protected Object create(Object obj) {
        return entityManager.merge(obj);
    }

    /**
     * Creates a query from the name given. The queries are found in their respective
     * model class in the @NamedQueries annotation.
     *
     * @param name The name of the query to return
     * @return The query
     */
    protected Query createNamedQuery(String name) {
        return entityManager.createNamedQuery(name);
    }

    /**
     * Finds the given object in the database.
     *
     * @param clazz The objects type
     * @param objectId The id of the object to find
     * @param <T>
     * @return The object that has been found in the database
     */
    protected <T> T find(Class<T> clazz, Long objectId) {
        return entityManager.find(clazz, objectId);
    }

    /**
     * Returns this User's instance of EntityManager
     * @return an EntityManager tied to this User instance
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * Run a basic read on the database.
     *
     * @param clazz The class of the object to find and return
     * @param objectId The object Id
     * @param <T> The class of the returned list
     * @return The object found in the database
     */
    protected <T> T read(Class<T> clazz, Object objectId) {
        return entityManager.find(clazz, objectId);
    }

    /**
     * Removes the object from the database.
     *
     * @param obj The object to remove
     */
    public void remove(Object obj) {
        // Make this entity managed by the current transaction
        obj = entityManager.merge(obj);

        entityManager.remove(obj);
    }

    /**
     * Update an object and persist to the database. Essentially merges
     * the state of the given Object into the current persistence context.
     *
     * @param obj The object to update
     */
    protected Object update(Object obj) {
        return entityManager.merge(obj);
    }

}