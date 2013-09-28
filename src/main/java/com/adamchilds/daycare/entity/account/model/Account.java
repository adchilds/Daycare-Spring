package com.adamchilds.daycare.entity.account.model;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>Represents a purchased account in the Daycare Management System. Accounts have
 * {@link com.adamchilds.daycare.entity.user.model.User}'s associated with them. These User's
 * are assigned specific roles and based on these roles, they're allowed to execute certain
 * functions on the account they're associated with.</p>
 *
 * @author Adam Childs
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllAccounts",
                    query = "SELECT ac FROM Account ac ORDER BY ac.id DESC"),
        @NamedQuery(name = "readAccountById",
                    query = "SELECT ac FROM Account ac WHERE ac.id = :accountId"),
        @NamedQuery(name = "readAccountByOwnerId",
                    query = "SELECT ac FROM Account ac WHERE ac.accountOwnerId = :ownerId")
})
@Entity
@Table(
        name = "DAYCARE_ACCOUNT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})}
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_OWNER_ID")
    private Long accountOwnerId; // The unique ID of the User that owns this account

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "SUBSCRIPTION_EXPIRATION_DATE")
    private Date subscriptionExpirationDate;

    @Column(name = "USER_SLOTS")
    private Integer userSlots; // The number of users allowed to be associated with this account

    public Long getId() {
        return id;
    }

    public Long getAccountOwnerId() {
        return accountOwnerId;
    }

    public void setAccountOwnerId(Long accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSubscriptionExpirationDate() {
        return subscriptionExpirationDate;
    }

    public void setSubscriptionExpirationDate(Date subscriptionExpirationDate) {
        this.subscriptionExpirationDate = subscriptionExpirationDate;
    }

    public Integer getUserSlots() {
        return userSlots;
    }

    public void setUserSlots(Integer userSlots) {
        this.userSlots = userSlots;
    }
}