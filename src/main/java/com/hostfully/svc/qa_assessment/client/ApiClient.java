package com.hostfully.svc.qa_assessment.client;

import com.hostfully.svc.qa_assessment.config.Configuration;
import com.hostfully.svc.qa_assessment.config.ConfigurationManager;
import com.hostfully.svc.qa_assessment.specs.InitialStateSpecs;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {

    protected static final Configuration configuration = ConfigurationManager.getConfiguration();
    protected RequestSpecification requestSpec;

    public ApiClient(){
        this.requestSpec = given().spec(InitialStateSpecs.set());
    }

    protected void setAllureRestAssured(){
        requestSpec.filter(new AllureRestAssured());
    }

}
