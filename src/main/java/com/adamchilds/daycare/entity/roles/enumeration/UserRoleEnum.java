package com.adamchilds.daycare.entity.roles.enumeration;

public enum UserRoleEnum {
    ROLE_USER(0, "ROLE_USER"),
    ROLE_ACCOUNT_OWNER(1, "ROLE_ACCOUNT_OWNER"),
    ROLE_EMPLOYEE(2, "ROLE_EMPLOYEE"),
    ROLE_ADMINISTRATOR(3, "ROLE_ADMINISTRATOR"),
    ROLE_SUPERUSER(4, "ROLE_SUPERUSER");

    private int roleId;
    private String roleText;

    UserRoleEnum(int roleId, String roleText) {
        this.roleId = roleId;
        this.roleText = roleText;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleText() {
        return roleText;
    }

}