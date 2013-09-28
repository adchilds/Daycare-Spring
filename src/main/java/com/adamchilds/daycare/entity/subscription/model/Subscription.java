package com.adamchilds.daycare.entity.subscription.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents an Account subscription. When a user registers and pays for x amount of months, a new
 * Subscription will be created. Subscription extensions will create a new Subscription, with a pointer
 * to the previous subscription so that history can be saved.
 *
 * @author Adam Childs
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllSubscriptions",
                    query = "SELECT s FROM Subscription s ORDER BY s.id DESC"),
        @NamedQuery(name = "readAllSubscriptionsByAccountId",
                    query = "SELECT s FROM Subscription s WHERE s.accountId = :subscriptionAccountId"),
        @NamedQuery(name = "readAllActiveSubscriptions",
                    query = "SELECT s FROM Subscription s WHERE s.isActive = true"),
        @NamedQuery(name = "readSubscriptionById",
                    query = "SELECT s FROM Subscription s WHERE s.id = :subscriptionId"),
        @NamedQuery(name = "readActiveSubscriptionByAccountId",
                    query = "SELECT s FROM Subscription s WHERE s.isActive = true AND s.accountId = :subscriptionAccountId")
})
@Entity
@Table(name = "DAYCARE_SUBSCRIPTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Subscription {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "ACCOUNT_ID")
    private Long accountId; // The accountId of the Account this Subscription is associated with

    @Basic
    @Column(name = "SUBSCRIPTION_LENGTH_IN_MONTHS")
    private Integer subscriptionLengthInMonths;

    @Basic
    @Column(name = "START_DATE")
    private Date startDate;

    @Basic
    @Column(name = "TERMINATION_DATE")
    private Date terminationDate;

    @Basic
    @Column(name = "OLD_SUBSCRIPTION_ID")
    private Integer oldSubscriptionId; // The id of a previous Subscription (used if account subscription is extended)

    @Basic
    @Column(name = "IS_ACTIVE")
    private boolean isActive; // Is this Subscription active?

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getSubscriptionLengthInMonths() {
        return subscriptionLengthInMonths;
    }

    public void setSubscriptionLengthInMonths(Integer subscriptionLengthInMonths) {
        this.subscriptionLengthInMonths = subscriptionLengthInMonths;
    }

    public boolean isActive() {
        return isActive;
    }

    /*
     * This method is here for Spring related purposes since things like JSPs and JSTL can't
     * recognize just the 'isActive' method.
     */
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}