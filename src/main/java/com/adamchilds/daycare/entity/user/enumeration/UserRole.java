package com.adamchilds.daycare.entity.user.enumeration;

public enum UserRole {
    ROLE_USER(0),
    ROLE_ACCOUNT_OWNER(1),
    ROLE_EMPLOYEE(2),
    ROLE_ADMINISTRATOR(3),
    ROLE_SUPERUSER(4);

    private int roleId;

    UserRole(int roleId) {
        this.roleId = roleId;
    }
}