package com.adamchilds.daycare.web.vaadin.ui.component;

import com.vaadin.annotations.Title;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Title("Dashboard")
public class Dashboard extends CustomComponent {

    @Autowired
    private ScrollableDropdownGroup scrollableDropdownGroup;

    /**
     * Set up the dashboard view after Spring processing has completed.
     */
    @PostConstruct
    public void postConstruct() {
        setCompositionRoot(body());
    }

    /**
     *
     */
    public VerticalLayout body() {
        VerticalLayout layout = new VerticalLayout();

        Button button = new Button();
        button.setStyleName("daycare_button button_large button_primary");
        button.setCaption("Learn more");
        layout.addComponent(button);

        scrollableDropdownGroup.addItem("Children");
        scrollableDropdownGroup.addItem("Employees");
        scrollableDropdownGroup.addItem("Calendar");
        scrollableDropdownGroup.addItem("Finances");
        layout.addComponent(scrollableDropdownGroup);

        return layout;
    }

}