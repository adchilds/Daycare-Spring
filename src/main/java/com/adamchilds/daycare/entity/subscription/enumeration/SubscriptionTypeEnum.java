package com.adamchilds.daycare.entity.subscription.enumeration;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p>Represents this different subscription types that users are allowed to purchase in the
 * Daycare Management System. Values contained here include the prices and lengths of each unique
 * subscription.</p>
 *
 * @author Adam Childs
 */
public enum SubscriptionTypeEnum {
    BASIC(0, 5.99, 1),
    STANDARD(1, 7.99, 1),
    PREMIUM(2, 9.99, 5),
    UNLIMITED(3, 0.00, 50);

    private int subscriptionTypeId;
    private double subscriptionMonthlyPrice;
    private int userSlots;

    SubscriptionTypeEnum(int subscriptionTypeId, double subscriptionMonthlyPrice, int userSlots) {
        this.subscriptionTypeId = subscriptionTypeId;
        this.subscriptionMonthlyPrice = subscriptionMonthlyPrice;
        this.userSlots = userSlots;
    }

    public int getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public double getSubscriptionMonthlyPrice() {
        return subscriptionMonthlyPrice;
    }

    public int getUserSlots() {
        return userSlots;
    }
}