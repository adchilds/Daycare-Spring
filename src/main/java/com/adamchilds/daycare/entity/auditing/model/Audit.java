package com.adamchilds.daycare.entity.auditing.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "readAllAudits",
                    query = "SELECT a FROM Audit a ORDER BY USER_ID ASC"),
        @NamedQuery(name = "readAllAuditsByType",
                    query = "SELECT a FROM Audit a WHERE a.auditType = :auditType"),
        @NamedQuery(name = "readAllAuditsByUserId",
                    query = "SELECT a FROM Audit a WHERE a.userId = :userId"),
        @NamedQuery(name = "readAllAuditsWithInformation",
                    query = "SELECT a FROM Audit a WHERE a.extraInformation LIKE :info"),
        @NamedQuery(name = "readAuditById",
                    query = "SELECT a FROM Audit a WHERE a.id = :auditId")
})
@Table(name = "DAYCARE_AUDIT")
public class Audit {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "AUDIT_DATE", nullable = false)
    private Date auditDate;

    @Basic
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "AUDIT_TYPE", nullable = false)
    private String auditType;

    @Basic
    @Column(name = "EXTRA_INFORMATION")
    private String extraInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audit)) return false;

        Audit audit = (Audit) o;

        if (!auditDate.equals(audit.auditDate)) return false;
        if (!auditType.equals(audit.auditType)) return false;
        if (extraInformation != null ? !extraInformation.equals(audit.extraInformation) : audit.extraInformation != null)
            return false;
        if (!id.equals(audit.id)) return false;
        if (!userId.equals(audit.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + auditDate.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + auditType.hashCode();
        result = 31 * result + (extraInformation != null ? extraInformation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}