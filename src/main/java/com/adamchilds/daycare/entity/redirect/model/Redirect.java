package com.adamchilds.daycare.entity.redirect.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Represents a single redirect that contains a source URL and a destination URL.
 *
 * @author Adam Childs
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "SITE_REDIRECT")
@NamedQueries(value = {
        @NamedQuery(name = "readAllRedirects",
                query = "SELECT r FROM Redirect r"
        )
})
public class Redirect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SOURCE_URL")
    private String sourceURL;

    @Column(name = "DESTINATION_URL")
    private String destinationURL;

    @Column(name = "START_DATE")
    private Calendar startDate;

    @Column(name = "END_DATE")
    private Calendar endDate;

    @Column(name = "CREATED_DATE")
    private Calendar createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * Denotes whether or not this {@link Redirect} is enabled or disabled regardless of any specified start or end
     * dates.
     */
    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "LAST_UPDATED_DATE")
    private Calendar lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    public Long getId() {
        return id;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getDestinationURL() {
        return destinationURL;
    }

    public void setDestinationURL(String destinationURL) {
        this.destinationURL = destinationURL;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Calendar getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Calendar lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Redirect redirect = (Redirect) o;

        if (!createdBy.equals(redirect.createdBy)) {
            return false;
        }
        if (createdDate != null ? (createdDate.getTimeInMillis() != redirect.createdDate.getTimeInMillis()) : redirect.createdDate != null) {
            return false;
        }
        if (!destinationURL.equals(redirect.destinationURL)) {
            return false;
        }
        if (endDate != null ? (endDate.getTimeInMillis() != redirect.endDate.getTimeInMillis()) : redirect.endDate != null) {
            return false;
        }
        if (!sourceURL.equals(redirect.sourceURL)) {
            return false;
        }
        if (startDate != null ? (startDate.getTimeInMillis() != redirect.startDate.getTimeInMillis()) : redirect.startDate != null) {
            return false;
        }
        if (enabled != redirect.enabled) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceURL.hashCode();
        result = 31 * result + destinationURL.hashCode();
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + createdBy.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}