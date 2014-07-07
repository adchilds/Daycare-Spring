package com.adamchilds.daycare.entity.address.model;

import javax.persistence.*;

/**
 * <p>Represents an address</p>
 *
 * @author Adam Childs
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllAddresses",
                query = "SELECT addr FROM Address addr ORDER BY addr.addressId DESC"),
        @NamedQuery(name = "readAllAddressesByCity",
                query = "SELECT addr FROM Address addr WHERE addr.city = :addressCity"),
        @NamedQuery(name = "readAllAddressesByCountry",
                query = "SELECT addr FROM Address addr WHERE addr.country = :addressCountry"),
        @NamedQuery(name = "readAllAddressesByState",
                query = "SELECT addr FROM Address addr WHERE addr.state = :addressState"),
        @NamedQuery(name = "readAddressById",
                query = "SELECT addr FROM Address addr WHERE addr.addressId = :addressId")
})
@Entity
@Table(name = "ADDRESS",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})}
)
public class Address {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long addressId;

    @Basic
    @Column(name = "STREET_ADDRESS_1")
    private String streetAddress1;

    @Basic
    @Column(name = "STREET_ADDRESS_2")
    private String streetAddress2;

    @Basic
    @Column(name = "PO_BOX")
    private String poBox;

    @Basic
    @Column(name = "CITY")
    private String city;

    @Basic
    @Column(name = "STATE")
    private String state;

    @Basic
    @Column(name = "ZIPCODE")
    private String zipcode;

    @Basic
    @Column(name = "COUNTRY")
    private String country;

    public Long getAddressId() {
        return addressId;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(
                "ADDRESS {" +
                "streetAddress1 = " + streetAddress1 +
                "streetAddress2 = " + streetAddress2 +
                "city = " + city +
                "state = " + state +
                "country = " + country +
                "zipcode = " + zipcode +
                "}"
        ).toString();
    }
}