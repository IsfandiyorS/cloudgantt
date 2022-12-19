package com.epam.cloudgantt.enums;

public enum UserType {
    CREATOR("CREATOR"),
    VIEWER("VIEWER"),
    ADMIN("ADMIN");

    private String code;

    UserType(String code) {
        this.code = code;
    }
}
