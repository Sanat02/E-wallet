package com.example.demo.enums;

public enum ContactType {
    TELEGRAM("телеграм"),
    EMAIL("email"),
    PHONE("номер телефона"),
    FACEBOOK("ссылка на Facebook"),
    LINKEDIN("ссылка на Linkedin");
    private String value;

    ContactType(String value) {
        this.value = value;
    }
    public String getValue()
    {
        return value;
    }
}
