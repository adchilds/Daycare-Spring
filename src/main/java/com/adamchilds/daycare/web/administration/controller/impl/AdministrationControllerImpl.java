package com.adamchilds.daycare.web.administration.controller.impl;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.auditing.enumeration.AuditTypeEnum;
import com.adamchilds.daycare.entity.auditing.model.Audit;
import com.adamchilds.daycare.entity.auditing.service.AuditService;
import com.adamchilds.daycare.entity.redirect.model.Redirect;
import com.adamchilds.daycare.entity.redirect.service.RedirectService;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.entity.user.util.UserUtil;
import com.adamchilds.daycare.web.administration.controller.AdministrationController;
import com.adamchilds.daycare.web.administration.form.RedirectForm;
import com.adamchilds.daycare.web.administration.validator.RedirectFormValidator;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Controller
public class AdministrationControllerImpl implements AdministrationController {
    private static final Logger logger = LoggerFactory.getLogger(AdministrationControllerImpl.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private RedirectService redirectService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserUtil userUtil;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminIndexPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<User> users = (ArrayList<User>) userService.readAllUsers();
        for (User user : users) {
            accounts.add(accountService.readAccountById(user.getAccountId()));
        }
        modelMap.put("userList", users);
        modelMap.put("accountList", accounts);

        return "administration_index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminUserAccountsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "administration_accounts";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminCachingPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Collection<String> cacheList = cacheManager.getCacheNames();

        modelMap.addAttribute("cacheList", cacheList);

        return "administration_cache";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminFinancesPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "administration_finances";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdminRedirectsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute("form") RedirectForm form,
                                        @RequestParam(value = "enableId", required = false) Long enableId,
                                        @RequestParam(value = "disableId", required = false) Long disableId,
                                        @RequestParam(value = "removeId", required = false) Long removeId) {
        if (form != null) {
            modelMap.addAttribute("form", form);
        } else {
            modelMap.addAttribute("form", new RedirectForm());
        }

        if (enableId != null) {
            Redirect redirect = redirectService.read(enableId);
            redirect.setEnabled(true);
            redirectService.update(redirect);

            Audit audit = new Audit();
            audit.setAuditDate(DateTime.now().toDate());
            audit.setAuditType(AuditTypeEnum.REDIRECT_ENABLED.getAuditType());
            audit.setExtraInformation("[" + redirect.getSourceURL() + "] --> [" + redirect.getDestinationURL() + "]");
            audit.setUserId(userUtil.getCurrentUser().getId());
            audit.setExtraInformation("USER=[" + userUtil.getCurrentUser().getEmailAddress() + "]");
            auditService.create(audit);
        } else if (disableId != null) {
            Redirect redirect = redirectService.read(disableId);
            redirect.setEnabled(false);
            redirectService.update(redirect);

            Audit audit = new Audit();
            audit.setAuditDate(DateTime.now().toDate());
            audit.setAuditType(AuditTypeEnum.REDIRECT_DISABLED.getAuditType());
            audit.setExtraInformation("[" + redirect.getSourceURL() + "] --> [" + redirect.getDestinationURL() + "]");
            audit.setUserId(userUtil.getCurrentUser().getId());
            audit.setExtraInformation("USER=[" + userUtil.getCurrentUser().getEmailAddress() + "]");
            auditService.create(audit);
        } else if (removeId != null) {
            Redirect redirect = redirectService.read(removeId);
            redirectService.remove(redirect);

            Audit audit = new Audit();
            audit.setAuditDate(DateTime.now().toDate());
            audit.setAuditType(AuditTypeEnum.REDIRECT_REMOVED.getAuditType());
            audit.setExtraInformation("[" + redirect.getSourceURL() + "] --> [" + redirect.getDestinationURL() + "]");
            audit.setUserId(userUtil.getCurrentUser().getId());
            audit.setExtraInformation("USER=[" + userUtil.getCurrentUser().getEmailAddress() + "]");
            auditService.create(audit);
        }

        modelMap.addAttribute("allRedirects", redirectService.readAllRedirects());

        return "administration_redirects";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postAdminRedirectsPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
                                         @ModelAttribute("form") RedirectForm form, BindingResult result) {
        if (form != null) {
            modelMap.addAttribute("form", form);

            // Validate the form
            new RedirectFormValidator().validate(form, result);

            if (result.hasErrors()) {
                modelMap.addAttribute("hasErrors", true);
                modelMap.addAttribute("errors", result.getAllErrors());
            } else {
                // Persist the new redirect
                Redirect redirect = new Redirect();
                redirect.setCreatedBy(userUtil.getCurrentUser().getEmailAddress());
                redirect.setCreatedDate(DateTime.now().toGregorianCalendar());
                redirect.setEnabled(true);
                redirect.setSourceURL(form.getSourceURL());
                redirect.setDestinationURL(form.getDestinationURL());

                if (StringUtils.hasText(form.getStartDate())) {
                    redirect.setStartDate(DateTime.parse(form.getStartDate()).toGregorianCalendar());
                }

                if (StringUtils.hasText(form.getEndDate())) {
                    redirect.setEndDate(DateTime.parse(form.getEndDate()).toGregorianCalendar());
                }

                redirect = redirectService.create(redirect);

                Audit audit = new Audit();
                audit.setAuditDate(DateTime.now().toDate());
                audit.setAuditType(AuditTypeEnum.REDIRECT_CREATED.getAuditType());
                audit.setExtraInformation("id=[" + redirect.getId() + "], sourceURL=[" + redirect.getSourceURL() + "] --> destinationURL=[" + redirect.getDestinationURL() + "]");
                audit.setUserId(userUtil.getCurrentUser().getId());

                auditService.create(audit);
            }
        } else {
            modelMap.addAttribute("form", new RedirectForm());
        }

        modelMap.addAttribute("allRedirects", redirectService.readAllRedirects());

        return "administration_redirects";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String removeUser(@PathVariable("userId") int userId, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.readAllUsers();

        User userToDelete;
        try {
            // Remove the User from the database
            userToDelete = userService.read(new Integer(userId).longValue());
            userService.remove(userToDelete);

            // Remove the User from the List<User>
            userList.remove(userToDelete);
        } catch (NullPointerException | IllegalArgumentException e) {
            // Nothing needs to be done except for a page reload. Reload will handle fixing the table.
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return "administration_index";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String updateUser(@PathVariable("userId") int userId, @ModelAttribute("user") User user, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("IN UPDATEUSER method");
        List<User> userList = userService.readAllUsers();
        User userToUpdate = userService.read(new Integer(userId).longValue());

        System.out.println("NEW USER: " + user);
        System.out.println("userToUpdate in updateUser() method (BEFORE): " + userToUpdate);

        try {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());

            System.out.println("userToUpdate in updateUser() method (AFTER): " + userToUpdate);

            userService.update(userToUpdate);

            System.out.println("NEW USER IN DATABASE: " + userService.read(new Integer(userId).longValue()));
        } catch (NullPointerException e) {
            System.out.println( "User cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new User());
        modelMap.put("userList", userList);

        return "administration_index";
    }

}