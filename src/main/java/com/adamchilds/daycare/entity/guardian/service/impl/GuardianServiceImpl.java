package com.adamchilds.daycare.entity.guardian.service.impl;

import com.adamchilds.daycare.entity.guardian.dao.GuardianDAO;
import com.adamchilds.daycare.entity.guardian.model.Guardian;
import com.adamchilds.daycare.entity.guardian.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class GuardianServiceImpl implements GuardianService {

    @Autowired
    private GuardianDAO guardianDAO;

    /**
     * {@inheritDoc}
     */
    public Guardian create(Guardian guardian) {
        return guardianDAO.create(guardian);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian find(Guardian guardian) {
        return guardianDAO.find(guardian);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian read(Object objectId) {
        return guardianDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Guardian> readAllGuardians() {
        return guardianDAO.readAllGuardians();
    }

    /**
     * {@inheritDoc}
     */
    public List<Guardian> readAllGuardiansByLastName(String lastName) {
        return guardianDAO.readAllGuardiansByLastName(lastName);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian readGuardianById(Long id) {
        return guardianDAO.readGuardianById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Guardian guardian) {
        guardianDAO.remove(guardian);
    }

    /**
     * {@inheritDoc}
     */
    public Guardian update(Guardian guardian) {
        return guardianDAO.update(guardian);
    }

}