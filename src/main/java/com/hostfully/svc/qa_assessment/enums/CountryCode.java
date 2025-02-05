package com.hostfully.svc.qa_assessment.enums;

public enum CountryCode {
    US("us"),
    BR("BR"),
    PL("PL"),
    IN("IN");

    private final String code;

    CountryCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
