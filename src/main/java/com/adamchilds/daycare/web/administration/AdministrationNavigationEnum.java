package com.adamchilds.daycare.web.administration;

public enum AdministrationNavigationEnum {

    INDEX("Home", "administration_index", "/administration/index.html"),
    USER_ACCOUNTS("User Accounts", "administration_users", "/administration/accounts.html"),
    FINANCES("Finances", "administration_finances", "/administration/finances.html"),
    CACHING("Caching", "administration_cache", "/administration/cache.html");

    private String textRepresentation;
    private String tilesDef;
    private String url;

    AdministrationNavigationEnum(String textRepresentation, String tilesDef, String url) {
        this.textRepresentation = textRepresentation;
        this.tilesDef = tilesDef;
        this.url = url;
    }

    public String getTextRepresentation() {
        return textRepresentation;
    }

    public String getTilesDef() {
        return tilesDef;
    }

    public String getUrl() {
        return url;
    }

}