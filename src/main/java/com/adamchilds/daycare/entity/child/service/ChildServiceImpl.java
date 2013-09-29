package com.adamchilds.daycare.entity.child.service;

import com.adamchilds.daycare.entity.child.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildDAO childDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Child child) {
        childDAO.create(child);
    }

    /**
     * {@inheritDoc}
     */
    public Child find(Child child) {
        return childDAO.find(child);
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return childDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Child read(Object objectId) {
        return childDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Child> readAllChildren() {
        return childDAO.readAllChildren();
    }

    /**
     * {@inheritDoc}
     */
    public Child readChildById(Long id) {
        return childDAO.readChildById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Child child) {
        childDAO.remove(child);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Child child) {
        return childDAO.update(child);
    }

}