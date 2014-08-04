package com.adamchilds.daycare.entity.auditing.service.impl;

import com.adamchilds.daycare.entity.auditing.dao.AuditDAO;
import com.adamchilds.daycare.entity.auditing.enumeration.AuditTypeEnum;
import com.adamchilds.daycare.entity.auditing.model.Audit;
import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.util.UserUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditDAO auditDAO;

    @Autowired
    private UserUtil userUtil;

    /**
     * {@inheritDoc}
     */
    public void create(Audit audit) {
        auditDAO.create(audit);
    }

    /**
     * {@inheritDoc}
     */
    public void createAuditForRequest(HttpServletRequest request) {
        Audit audit = new Audit();
        audit.setAuditDate(new Date(new java.util.Date().getTime()));
        audit.setAuditType(AuditTypeEnum.WEB_REQUEST.getAuditType());

        String info = "METHOD=[" + request.getMethod() + "], " +
                      "URI=[" + request.getRequestURI() + "], " +
                      "IP=[" + request.getRemoteAddr() + "], " +
                      "USER_AGENT=[" + request.getHeader("user-agent") + "]";
        audit.setExtraInformation(info);

        if (userUtil.isUserAuthenticated()) {
            User user = userUtil.getCurrentUser();
            if (user != null) {
                audit.setUserId(userUtil.getCurrentUser().getId());
            } else {
                audit.setUserId(0l);
            }
        } else {
            audit.setUserId(0l);
        }

        create(audit);
    }

    /**
     * {@inheritDoc}
     */
    public void createAuditForLogin(User user, boolean success) {
        Audit audit = new Audit();
        audit.setUserId(user.getId());
        audit.setAuditType(AuditTypeEnum.ACCOUNT_LOGIN.getAuditType());
        audit.setExtraInformation("SUCCESS=[" + Boolean.toString(success) + "]");
        audit.setAuditDate(DateTime.now().toDate());

        create(audit);
    }

    /**
     * {@inheritDoc}
     */
    public Audit find(Audit audit) {
        return auditDAO.find(audit);
    }

    /**
     * {@inheritDoc}
     */
    public EntityManager getEntityManager() {
        return auditDAO.getEntityManager();
    }

    /**
     * {@inheritDoc}
     */
    public Audit read(Object objectId) {
        return auditDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Audit> readAllAudits() {
        return auditDAO.readAllAudits();
    }

    /**
     * {@inheritDoc}
     */
    public List<Audit> readAllAuditsByType(AuditTypeEnum auditTypeEnum) {
        return auditDAO.readAllAuditsByType(auditTypeEnum);
    }

    /**
     * {@inheritDoc}
     */
    public List<Audit> readAllAuditsByUserId(Long userId) {
        return auditDAO.readAllAuditsByUserId(userId);
    }

    /**
     * {@inheritDoc}
     */
    public Audit readAuditById(Long id) {
        return auditDAO.readAuditById(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<Audit> readAllAuditsWithInformation(String info) {
        return auditDAO.readAllAuditsWithInformation(info);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Audit audit) {
        auditDAO.remove(audit);
    }

    /**
     * {@inheritDoc}
     */
    public Object update(Audit audit) {
        return auditDAO.update(audit);
    }

}