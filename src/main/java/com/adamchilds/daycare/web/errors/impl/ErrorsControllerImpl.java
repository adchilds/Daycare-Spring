package com.adamchilds.daycare.web.errors.impl;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.web.errors.ErrorsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 */
@Controller
public class ErrorsControllerImpl implements ErrorsController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorsControllerImpl.class);

    @Autowired
    private AuditService auditService;

    /**
     * {@inheritDoc}
     */
    public String get403(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        /*
         * Add an audit to the DB
         */
        auditService.createAuditForRequest(request);

        return "error_403";
    }

    /**
     * {@inheritDoc}
     */
    public String get404(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        /*
         * Add an audit to the DB
         */
        auditService.createAuditForRequest(request);

        return "error_404";
    }

}