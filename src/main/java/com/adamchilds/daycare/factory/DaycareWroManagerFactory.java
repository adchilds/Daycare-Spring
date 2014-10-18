package com.adamchilds.daycare.factory;

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class DaycareWroManagerFactory extends ConfigurableWroManagerFactory {
    private static final Logger logger = LoggerFactory.getLogger(DaycareWroManagerFactory.class);

    private static final String WRO_PROPS_LOCATION = "/wro4j/wro.properties";
    private static final String WRO_XML_LOCATION = "/wro4j/wro.xml";

    /**
     * {@inheritDoc}
     */
    @Override
    protected WroModelFactory newModelFactory() {
        return new XmlModelFactory() {
            @Override
            protected InputStream getModelResourceAsStream() throws IOException {
                final InputStream stream = Resources.getResource(WRO_XML_LOCATION).openStream();

                if (stream == null) {
                    throw new IOException("Invalid resource requested: " + WRO_XML_LOCATION);
                }

                return stream;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Properties newConfigProperties() {
        final Properties props = new Properties();

        try {
            // Find the properties file and open the stream
            InputStream stream = Resources.getResource(WRO_PROPS_LOCATION).openStream();

            // Load the properties
            props.load(stream);
        } catch (Exception e) {
            logger.error("No configuration property file found. Using default values.", e);
        }

        return props;
    }

}