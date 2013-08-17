package com.adamchilds.daycare.user.model;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "readAllUserModels", query = "SELECT um FROM UserModel um")})
@Entity
@Table(name = "USER_MODEL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserModel {

    @Id // Indicates that this is a unique primary key
    @GeneratedValue // Indicates that this value will be automatically generated
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "USERNAME", length = 24, unique = true)
    private String username = "";

    @Basic
    @Column(name = "PASSWORD", length = 500)
    private String password = "";

    public UserModel() {
        setUsername("");
        setPassword("");
    }

    public UserModel(String u, String p) {
        setUsername(u);
        setPassword(p);
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String u) {
        this.username = u;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public String toString() {
        return "Username: [" + this.username + "] Password: [" + this.password + "]";
    }
}
