package com.hostfully.svc.qa_assessment.specs;

import com.hostfully.svc.qa_assessment.config.Configuration;
import com.hostfully.svc.qa_assessment.config.ConfigurationManager;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class InitialStateSpecs {

    private static final Configuration configuration = ConfigurationManager.getConfiguration();

    private InitialStateSpecs(){
    }

    private static RequestSpecBuilder baseBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(configuration.baseURI())
                .setContentType(configuration.contentType())
                .setAuth(new PreemptiveBasicAuthScheme() {{
                    setUserName(configuration.username());
                    setPassword(configuration.password());
                }})
                ;
    }

    public static RequestSpecification set() {
        return baseBuilder()
                .build();
    }
}
