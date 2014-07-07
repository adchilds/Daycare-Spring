package com.adamchilds.daycare.entity.guardian.dao.impl;

import com.adamchilds.daycare.entity.guardian.dao.GuardianDAO;
import com.adamchilds.daycare.entity.guardian.model.Guardian;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class GuardianDAOImpl extends AbstractJPADAO implements GuardianDAO {

    /**
     * {@inheritDoc}
     */
    public Guardian create(Guardian guardian) {
        return (Guardian) super.create(guardian);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian find(Guardian guardian) {
        return super.find(Guardian.class, guardian.getId());
    }

    /**
     * {@inheritDoc}
     */
    public Guardian read(Object objectId) {
        return super.read(Guardian.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Guardian> readAllGuardians() {
        Query query = super.createNamedQuery( "readAllGuardians" );

        return (List<Guardian>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Guardian> readAllGuardiansByLastName(String lastName) {
        Query query = super.createNamedQuery( "readAllGuardiansByLastName" )
                .setParameter("guardianLastName", lastName);

        return (List<Guardian>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Guardian readGuardianById(Long id) {
        Query query = super.createNamedQuery( "readGuardianById" )
                .setParameter("guardianId", id);

        return (Guardian) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Guardian guardian) {
        super.remove(guardian);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian update(Guardian guardian) {
        return (Guardian) super.update(guardian);
    }

}