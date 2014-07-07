package com.adamchilds.daycare.entity.subscription.enumeration;

/**
 * Represents this different subscription types that users are allowed to purchase in the
 * Daycare Management System. Values contained here include the prices and lengths of each unique
 * subscription.
 *
 * @author Adam Childs
 */
public enum SubscriptionTypeEnum {
    BASIC(0, 7.99),
    STANDARD(1, 11.99),
    PREMIUM(2, 17.99);

    private int subscriptionTypeId;
    private double subscriptionMonthlyPrice;

    SubscriptionTypeEnum(int subscriptionTypeId, double subscriptionMonthlyPrice) {
        this.subscriptionTypeId = subscriptionTypeId;
        this.subscriptionMonthlyPrice = subscriptionMonthlyPrice;
    }

    public int getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public double getSubscriptionMonthlyPrice() {
        return subscriptionMonthlyPrice;
    }

}