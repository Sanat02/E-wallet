package com.example.demo.enums;

public enum AccountType {
    USER("User"),
    ADMIN("Admin");
    private String value;

    AccountType(String value) {
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
