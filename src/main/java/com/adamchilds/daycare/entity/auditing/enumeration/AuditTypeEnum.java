package com.adamchilds.daycare.entity.auditing.enumeration;

/**
 * This enum represents all of the possible audit events that we would like to track
 * throughout the website. When a user completes some action, we will store information
 * in the database regarding the action with a timestamp, and other important
 * information.
 *
 * @author Adam Childs
 * @since 1.0
 */
public enum AuditTypeEnum {

    /*
     * User/Account Management audits
     */
    ACCOUNT_REGISTRATION("Account Registration"),
    ACCOUNT_LOGIN("Account Login"),
    ACCOUNT_LOGOUT("Account Logout"),

    /*
     * Daycare Management System action audits
     */
    ACTION_CREATE_CHILD("Create Child"),
    ACTION_REMOVE_CHILD("Remove Child"),
    ACTION_VIEW_CHILD("View Child"),

    ACTION_CREATE_GUARDIAN("Create Guardian"),
    ACTION_REMOVE_GUARDIAN("Remove Guardian"),
    ACTION_VIEW_GUARDIAN("View Guardian"),

    ACTION_CREATE_FAMILY("Create Family"),
    ACTION_REMOVE_FAMILY("Remove Family"),
    ACTION_VIEW_FAMILY("View Family"),

    /*
     * Request method audits
     */
    WEB_REQUEST("Web Request"),

    /*
     * Redirect Service audits
     */
    REDIRECT_CREATED("Redirect Created"),
    REDIRECT_DISABLED("Redirect Disabled"),
    REDIRECT_ENABLED("Redirect Enabled"),
    REDIRECT_REMOVED("Redirect Removed"),
    REDIRECT_UPDATED("Redirect Updated"),

    /*
     * Payment audits
     */
    PAYMENT_RECEIVED("Payment Received"),
    PAYMENT_REJECTED("Payment Rejected"),
    PAYMENT_SENT("Payment Sent");

    private String auditType;

    AuditTypeEnum(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditType() {
        return auditType;
    }

}