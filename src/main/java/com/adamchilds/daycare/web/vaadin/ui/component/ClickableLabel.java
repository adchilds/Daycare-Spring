package com.adamchilds.daycare.web.vaadin.ui.component;

import com.vaadin.event.LayoutEvents;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Extension of a {@link Label} to allow for handling click events.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class ClickableLabel extends CustomComponent {

    private Label label;

    public ClickableLabel() {
        setCompositionRoot(createClickableLabel());
    }

    public ClickableLabel(String caption) {
        setCompositionRoot(createClickableLabel(caption));
    }

    public String getContent() {
        return label.getValue();
    }

    public void setContent(String caption) {
        label.setValue(caption);
    }

    private VerticalLayout createClickableLabel() {
        return createClickableLabel("");
    }

    private VerticalLayout createClickableLabel(String caption) {
        VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("clickable_label");

        label = new Label(caption);
        label.setStyleName("clickable_label_text");
        label.setSizeUndefined();
        layout.addComponent(label);

        layout.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                System.out.println(getContent());
            }
        });

        return layout;
    }

}