package com.adamchilds.daycare.entity.redirect.service.impl;

import com.adamchilds.daycare.entity.redirect.RedirectUtil;
import com.adamchilds.daycare.entity.redirect.dao.RedirectDAO;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.entity.redirect.service.RedirectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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

    @Autowired
    private CacheManager cacheManager;

    /**
     * {@inheritDoc}
     */
    public Redirect create(Redirect redirect) {
        redirect = redirectDAO.create(redirect);

        clearRedirectCache();

        return redirect;
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
    public List<Redirect> readAllRedirectsByDestinationURI(String destinationURI) {
        return redirectDAO.readAllRedirectsByDestinationURI(destinationURI);
    }

    /**
     * {@inheritDoc}
     */
    public Redirect readRedirectByURI(String uri) {
        return redirectDAO.readRedirectByURI(uri);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Redirect redirect) {
        redirectDAO.remove(redirect);

        clearRedirectCache();
    }

    /**
     * {@inheritDoc}
     */
    public void update(Redirect redirect) {
        redirectDAO.update(redirect);

        clearRedirectCache();
    }

    /**
     * {@inheritDoc}
     */
    public void clearRedirectCache() {
        if (logger.isDebugEnabled()) {
            logger.debug("Clearing the Redirect cache...");
        }

        cacheManager.getCache(RedirectUtil.CACHE_READ_ALL_REDIRECTS).clear();
        cacheManager.getCache(RedirectUtil.CACHE_READ_REDIRECT_BY_URI).clear();
        cacheManager.getCache(RedirectUtil.CACHE_READ_ALL_REDIRECTS_BY_DESTINATION).clear();
    }

}