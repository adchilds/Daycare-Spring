package com.adamchilds.daycare.filter;

import com.adamchilds.daycare.factory.DaycareWroManagerFactory;
import ro.isdc.wro.http.ConfigurableWroFilter;
import ro.isdc.wro.manager.factory.WroManagerFactory;

/**
 * Extension of the {@link ConfigurableWroFilter} to allow for overriding the default {@link WroManagerFactory}
 *
 * @author Adam Childs
 * @since 1.0
 */
public class DaycareWroFilter extends ConfigurableWroFilter {

    /**
     * {@inheritDoc}
     */
    @Override
    protected WroManagerFactory newWroManagerFactory() {
        return new DaycareWroManagerFactory();
    }

}