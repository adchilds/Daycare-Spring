package com.adamchilds.daycare.entity.roles.model;

import javax.persistence.*;

/**
 * Represents the various {@link com.adamchilds.daycare.entity.user.model.User}s and their {@link com.adamchilds.daycare.entity.roles.enumeration.UserRoleEnum}.
 *
 * @author Adam Childs
 * @since 1.0
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "readAllUserRoles",
                    query = "SELECT ur FROM UserRole ur"),
        @NamedQuery(name = "readAllRolesByUserId",
                    query = "SELECT ur FROM UserRole ur WHERE ur.userId = :userId"),
        @NamedQuery(name = "readAllUserIdsByRole",
                    query = "SELECT ur FROM UserRole ur WHERE ur.role = :userRole"),
        @NamedQuery(name = "readUserRoleByUserIdAndUserRole",
                    query = "SELECT ur FROM UserRole ur WHERE ur.userId = :userId AND ur.role = :userRole")
})
@Table(name = "USER_ROLES")
public class UserRole {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "USER_ID")
    private long userId;

    @Basic
    @Column(name = "USER_ROLE")
    private String role;

    public Long getId() {
        return this.id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}