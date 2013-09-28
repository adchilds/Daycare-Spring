package com.adamchilds.daycare.entity.user.model;

import com.adamchilds.daycare.entity.user.enumeration.UserRole;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>Represents an individual user in the Daycare Management System</p>
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllUsers",
                    query = "SELECT um FROM User um ORDER BY um.username DESC"),
        @NamedQuery(name = "readAllUsersByUserRole",
                    query = "SELECT um FROM User um WHERE um.role LIKE :userRole"),
        @NamedQuery(name = "readAllUsersByAccountId",
                    query = "SELECT um FROM User um WHERE um.associatedAccountId LIKE :userAccount"),
        @NamedQuery(name = "readUserById",
                    query = "SELECT um FROM User um WHERE um.id LIKE :userId"),
        @NamedQuery(name = "readUserByUsername",
                    query = "SELECT um FROM User um WHERE um.username LIKE :userName"),
        @NamedQuery(name = "readUserByEmail",
                    query = "SELECT um FROM User um WHERE um.emailAddress LIKE :userEmail")
})
@Entity
@Table(name = "DAYCARE_USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "USERNAME", length = 24, unique = true)
    private String username;

    @Basic
    @Column(name = "PASSWORD", length = 500)
    private String password;

    @Basic
    @Column(name = "EMAIL_ADDRESS", length = 100)
    private String emailAddress;

    @Column(name = "CREATED")
    private Date createdDate;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "USER_ROLE")
    private UserRole role;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "ACCOUNT_ID")
    private long accountId;

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String toString() {
        return "Username: [" + this.username + "] Password (hashed): [" + this.password + "]";
    }
}
