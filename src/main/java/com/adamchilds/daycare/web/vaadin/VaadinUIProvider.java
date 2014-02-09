package com.adamchilds.daycare.web.vaadin;

import com.vaadin.server.VaadinRequest;
import ru.xpoft.vaadin.SpringUIProvider;

/**
 * This class is the main delegator for sending specified URIs to different
 * Vaadin UI views.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class VaadinUIProvider extends SpringUIProvider {

    /**
     * Given a Vaadin request, delegates which UI should be shown to
     * the user.
     *
     * @param vaadinRequest the {@link VaadinRequest} being handled.
     * @return a {@link String} representing the bean name of the UI to show
     */
    @Override
    protected String getUIBeanName(VaadinRequest vaadinRequest) {
        if (vaadinRequest.getPathInfo().contains("daycare")) {
            return "daycareUI";
        }

        return "errorUI";
    }

}