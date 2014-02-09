package com.adamchilds.daycare.web.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This class is the main entry point for the Daycare Management System UI and
 * service. After users login, a new instance of this UI will be created for them.
 *
 * @author Adam Childs
 * @since 1.0
 */
@Component("daycareUI")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Theme("daycare")
public class DaycareUI extends UI {

    /**
     * Sets up the view by adding various components to the layout. To set up the view, instantiates each
     * individual component and then calls their respective #postConstruct() method in order to allow any Spring
     * processing and configuration to happen before the UI is built. A {@link VerticalLayout} is created with the
     * required content to build the Hub Library page.
     *
     * @param request the {@link VaadinRequest} associated with this UI view
     */
    public void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(new Button("Test"));
        setContent(layout);
        setSizeFull();
    }

}