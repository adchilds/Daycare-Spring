package com.adamchilds.daycare.web.vaadin.ui.component;

import com.vaadin.ui.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScrollableDropdownGroup extends CustomComponent {

    private ArrayList<String> items = new ArrayList<>();
    private VerticalLayout parentLayout = new VerticalLayout();

    @PostConstruct
    public void postConstruct() {
        parentLayout.setStyleName("scrollable_dropdown_group");
        parentLayout.setSizeUndefined();

        setCompositionRoot(getComponentLayout());
    }

    public VerticalLayout getComponentLayout() {
        for (String item : items) {
            ClickableLabel label = new ClickableLabel(item);
            label.addStyleName("scrollable_dropdown_group_item");

            parentLayout.addComponent(label);
        }

        return parentLayout;
    }

    /**
     * Updates the view of this {@link ScrollableDropdownGroup} component.
     */
    public void update() {
        parentLayout.removeAllComponents();
        getComponentLayout();
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = (ArrayList<String>) items;
        update();
    }

    public void addItem(String item) {
        this.items.add(item);
        update();
    }

}