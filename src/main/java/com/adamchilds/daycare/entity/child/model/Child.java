package com.adamchilds.daycare.entity.child.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a child associated with an account in the Daycare Management System
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllChildren",
                    query = "SELECT c FROM Child c ORDER BY c.lastName ASC"),
        @NamedQuery(name = "readAllChildrenByAccountId",
                    query = "SELECT c FROM Child c WHERE c.accountId = :accountId"),
        @NamedQuery(name = "readChildById",
                    query = "SELECT c FROM Child c WHERE c.id = :childId")
})
@Entity
@Table(name = "DAYCARE_CHILD")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Child {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Basic
    @Column(name = "GUARDIAN_ONE_ID")
    private Long guardianOneId;

    @Basic
    @Column(name = "GUARDIAN_TWO_ID")
    private Long guardianTwoId;

    @Basic
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Basic
    @Column(name = "MIDDLE_INITIAL")
    private Character middleInitial;

    @Basic
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Basic
    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthDate;

    @Basic
    @Column(name = "IS_CURRENT", nullable = false)
    private boolean isCurrent; // Does the Child currently attend the daycare?

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getGuardianOneId() {
        return guardianOneId;
    }

    public void setGuardianOneId(Long guardianOneId) {
        this.guardianOneId = guardianOneId;
    }

    public Long getGuardianTwoId() {
        return guardianTwoId;
    }

    public void setGuardianTwoId(Long guardianTwoId) {
        this.guardianTwoId = guardianTwoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(Character middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }
}