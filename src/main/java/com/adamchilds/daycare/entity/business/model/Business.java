package com.adamchilds.daycare.entity.business.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a {@link com.adamchilds.daycare.entity.user.model.User}'s business/company
 * and the information associated with a business.
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllBusinesses",
                query = "SELECT b FROM Business b ORDER BY b.businessId DESC"),
        @NamedQuery(name = "readBusinessById",
                query = "SELECT b FROM Business b WHERE b.businessId = :businessId")
})
@Entity
@Table(name = "DAYCARE_BUSINESS",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})}
)
public class Business {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long businessId;

    @Basic
    @Column(name = "OWNER_ID")
    private Long ownerId;

    @Basic
    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Basic
    @Column(name = "OPENING_DATE")
    private Date openingDate;

    @Basic
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}