package com.adamchilds.daycare.entity.redirect.dao.impl;

import com.adamchilds.daycare.entity.redirect.dao.RedirectDAO;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class RedirectDAOImpl extends AbstractJPADAO implements RedirectDAO {
    private static final Logger logger = LoggerFactory.getLogger(RedirectDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Redirect redirect) {
        super.create(redirect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Redirect find(Redirect redirect) {
        return super.find(redirect.getClass(), redirect.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Redirect read(Object objectId) {
        return super.read(Redirect.class, objectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Redirect readRedirectByURI(String requestURI) throws DataIntegrityViolationException {
        List<Redirect> allRedirects = readAllRedirects();

        for (Redirect redirect : allRedirects) {
            if (redirect.getSourceURL().equals(requestURI) && redirect.isEnabled()) {
                return redirect;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Redirect> readAllRedirects() {
        Query query = super.createNamedQuery( "readAllRedirects" );

        return (List<Redirect>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Redirect redirect) {
        super.remove(redirect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Redirect redirect) {
        super.update(redirect);
    }
}