package com.example.demo.enums;

public enum AccountType {
    JOB_SEEKER("Job Seeker"),
    EMPLOYER("Employer");
    private String value;

    AccountType(String value) {
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
