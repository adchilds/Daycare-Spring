package com.adamchilds.daycare.web.contact.controller.impl;

import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.web.contact.controller.ContactUsController;
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
public class ContactUsControllerImpl implements ContactUsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactUsControllerImpl.class);

    @Autowired
    private AuditService auditService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getContactUsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        /*
         * Add an audit to the DB
         */
        auditService.createAuditForRequest(request);

        modelMap.put("audits", auditService.readAllAuditsWithInformation("404"));

        return "contact_us";
    }

}