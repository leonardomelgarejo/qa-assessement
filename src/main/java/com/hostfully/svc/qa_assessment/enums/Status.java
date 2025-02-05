package com.hostfully.svc.qa_assessment.enums;

public enum Status {
    SCHEDULED("SCHEDULED"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String statusCode;

    Status(String statusCode){
        this.statusCode = statusCode;
    }

    public String getStatus(){
        return statusCode;
    }
}
