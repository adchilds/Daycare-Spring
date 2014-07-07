package com.adamchilds.daycare.entity.redirect.dao.impl;

import com.adamchilds.daycare.entity.redirect.RedirectUtil;
import com.adamchilds.daycare.entity.redirect.dao.RedirectDAO;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.jpa.AbstractJPADAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
    public Redirect create(Redirect redirect) {
        return (Redirect) super.create(redirect);
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
    @SuppressWarnings("unchecked")
    public List<Redirect> readAllRedirects() {
        Query query = super.createNamedQuery( "readAllRedirects" );

        return (List<Redirect>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Redirect> readAllRedirectsByDestinationURI(String destinationURI) {
        Query query = super.createNamedQuery( "readAllRedirectsByDestinationURI" )
                .setParameter("destinationURI", destinationURI);

        return (List<Redirect>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Redirect readRedirectByURI(String requestURI) {
        Query query = super.createNamedQuery( "readRedirectByURI" )
                .setParameter("sourceURL", requestURI);

        Redirect redirect = null;

        try {
            redirect = (Redirect) query.getSingleResult();
        } catch (NoResultException nre) {
            if (logger.isDebugEnabled()) {
                logger.debug("No redirect found for the given sourceURL=[" + requestURI + "]");
            }
        } catch (NonUniqueResultException nure) {
            logger.error("Multiple redirects found for the given sourceURL=[" + requestURI + "]");

            return RedirectUtil.createErrorRedirect();
        } catch (Exception e) {
            logger.error("An error occurred when reading a redirect for the given sourceURL=[" + requestURI + "]");

            return RedirectUtil.createErrorRedirect();
        }

        return redirect;
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