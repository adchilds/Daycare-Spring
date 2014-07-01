package com.adamchilds.daycare.entity.redirect.service.impl;

import com.adamchilds.daycare.entity.redirect.dao.RedirectDAO;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.entity.redirect.service.RedirectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class RedirectServiceImpl implements RedirectService {
    private static final Logger logger = LoggerFactory.getLogger(RedirectServiceImpl.class);

    @Autowired
    private RedirectDAO redirectDAO;

    /**
     * {@inheritDoc}
     */
    public void create(Redirect redirect) {
        redirectDAO.create(redirect);
    }

    /**
     * {@inheritDoc}
     */
    public Redirect find(Redirect redirect) {
        return redirectDAO.find(redirect);
    }

    /**
     * {@inheritDoc}
     */
    public Redirect read(Object objectId) {
        return redirectDAO.read(objectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Redirect> readAllRedirects() {
        return redirectDAO.readAllRedirects();
    }

    /**
     * {@inheritDoc}
     */
    public Redirect getRedirect(String uri) {
        try {
            return redirectDAO.readRedirectByURI(uri);
        } catch (DataIntegrityViolationException e) {
            logger.error("Error looking up redirect for URI=[" + uri + "]", e);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Redirect redirect) {
        redirectDAO.remove(redirect);
    }

    /**
     * {@inheritDoc}
     */
    public void update(Redirect redirect) {
        redirectDAO.update(redirect);
    }

}