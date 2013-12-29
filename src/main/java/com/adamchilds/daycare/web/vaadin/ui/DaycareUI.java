package com.adamchilds.daycare.web.vaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This class is the main entry point for the Daycare Management System UI and
 * service. After users login, a new instance of this UI will be created for them.
 *
 * @author Adam Childs
 * @since 1.0
 */
@Component
@Scope("prototype")
public class DaycareUI extends UI {

    /**
     * Delegates {@link VaadinRequest}'s from each user and initiates a new UI
     * instance per request, displaying the Daycare Management System to the user.
     *
     * @param request the {@link VaadinRequest} sent by a user
     */
    public void init(VaadinRequest request) {
        setContent(null);
        setSizeFull();
    }

}