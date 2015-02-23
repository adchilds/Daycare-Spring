package com.adamchilds.daycare.entity.child.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "GUARDIAN_ONE_ID")
    private Long guardianOneId;

    @Column(name = "GUARDIAN_TWO_ID")
    private Long guardianTwoId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_INITIAL")
    private Character middleInitial;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthDate;

    @Column(name = "IS_CURRENT", nullable = false)
    private boolean isCurrent; // Does the Child currently attend the daycare?

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "TERMINATION_DATE")
    private Date terminationDate;

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

    public void setCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}