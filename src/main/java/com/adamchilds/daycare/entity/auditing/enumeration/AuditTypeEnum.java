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
     * Daycare Mangement System action audits
     */
    ACTION_CREATECHILD("Create Child"),
    ACTION_REMOVECHILD("Remove Child"),
    ACTION_VIEWCHILD("View Child"),

    /*
     * Request method audits
     */
    WEB_REQUEST("Web Request"),

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