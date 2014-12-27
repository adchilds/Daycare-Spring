package com.adamchilds.daycare.internationalization;

/**
 * A utility service to grab internationalized messages from the resources messages bundle via a
 * service method {@link #get(String)}.
 *
 * @author Adam Childs
 * @since 1.0
 */
public interface MessageService {

    /**
     * Get a message using the current locale from the current web request
     *
     * @param code the message code
     * @return the internationalized message for the given code
     */
    public String get(String code);

    /**
     * Get a message using the current locale and add the specified arguments to the message's dynamic
     * fields ({0}, {1}, {2}, ...).
     *
     * @param code the message code
     * @param args the arguments to add to the message
     * @return the message from the properties file
     */
    public String get(String code, Object[] args);

}