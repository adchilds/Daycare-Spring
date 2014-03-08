package com.adamchilds.daycare.entity.auditing.dao.impl;

import com.adamchilds.daycare.entity.auditing.dao.AuditDAO;
import com.adamchilds.daycare.entity.auditing.enumeration.AuditTypeEnum;
import com.adamchilds.daycare.entity.auditing.model.Audit;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class AuditDAOImpl extends AbstractJPADAO implements AuditDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Audit audit) {
        super.create(audit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Audit find(Audit audit) {
        return super.find(audit.getClass(), audit.getId());
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
    public Audit read(Object objectId) {
        return super.read(Audit.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Audit> readAllAudits() {
        Query query = super.createNamedQuery( "readAllAudits" );

        return (List<Audit>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Audit> readAllAuditsByType(AuditTypeEnum auditTypeEnum) {
        Query query = super.createNamedQuery( "readAllAuditsByType" )
                .setParameter("auditType", auditTypeEnum.getAuditType());

        return (List<Audit>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Audit> readAllAuditsByUserId(Long userId) {
        Query query = super.createNamedQuery( "readAllAuditsByUserId" )
                .setParameter("userId", userId);

        return (List<Audit>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Audit readAuditById(Long id) {
        Query query = super.createNamedQuery( "readAuditById" )
                .setParameter("auditId", id);

        return (Audit) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Audit audit) {
        super.remove(audit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object update(Audit audit) {
        return super.update(audit);
    }

}