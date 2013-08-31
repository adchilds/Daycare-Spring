package com.adamchilds.daycare.exception;

/**
 * A {@link com.adamchilds.daycare.exception.DaycareException} encapsulates any exceptions thrown in the
 * Daycare Management System webapp and logs the errors so that they may be viewed at a future date.
 */
public class DaycareException extends Exception {

    public DaycareException(String message) {
        super(message);
        // TODO: Add logging
    }

    public DaycareException(String message, Throwable throwable) {
        super(message, throwable);
        // TODO: Add logging
    }
}