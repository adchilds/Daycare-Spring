package com.adamchilds.daycare.entity.child.dao.impl;

import com.adamchilds.daycare.entity.child.dao.ChildDAO;
import com.adamchilds.daycare.entity.child.model.Child;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class ChildDAOImpl extends AbstractJPADAO implements ChildDAO {

    /**
     * {@inheritDoc}
     */
    public void create(Child child) {
        super.create(child);
    }

    /**
     * {@inheritDoc}
     */
    public Child find(Child child) {
        return super.find(child.getClass(), child.getId());
    }

    /**
     * {@inheritDoc}
     */
    public Child read(Object objectId) {
        return super.read(Child.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Child> readAllChildren() {
        Query query = super.createNamedQuery( "readAllChildren" );

        return (List<Child>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public List<Child> readAllChildrenByAccountId(Long accountId) {
        Query query = super.createNamedQuery( "readAllChildrenByAccountId" )
                .setParameter("accountId", accountId);

        return (List<Child>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Child readChildById(Long id) {
        Query query = super.createNamedQuery( "readChildById" )
                .setParameter("childId", id);

        return (Child) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Child child) {
        super.remove(child);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Child child) {
        return super.update(child);
    }

}