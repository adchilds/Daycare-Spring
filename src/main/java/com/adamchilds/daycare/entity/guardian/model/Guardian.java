package com.adamchilds.daycare.entity.guardian.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a guardian that has custody of a {@link com.adamchilds.daycare.entity.child.model.Child}
 * or takes care of a child.
 *
 * @author Adam Childs
 * @since 1.0
 */
@NamedQueries(value = {
        @NamedQuery(name = "readAllGuardians",
                    query = "SELECT g FROM Guardian g ORDER BY g.lastName ASC"),
        @NamedQuery(name = "readAllGuardiansByLastName",
                    query = "SELECT g FROM Guardian g WHERE g.lastName = :guardianLastName"),
        @NamedQuery(name = "readGuardianById",
                    query = "SELECT g FROM Guardian g WHERE g.id = :guardianId")
})
@Entity
@Table(name = "DAYCARE_GUARDIAN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Guardian {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}