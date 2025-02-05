package com.hostfully.svc.qa_assessment.client;

import com.hostfully.svc.qa_assessment.factory.PropertyDataFactory;
import com.hostfully.svc.qa_assessment.model.Property;
import io.restassured.response.Response;

public class PropertyClient extends ApiClient{

    private static final String PROPERTIES_ENDPOINT = configuration.basePathProperties();

    public Response getProperties(){
        setAllureRestAssured();
        return requestSpec
                .get(PROPERTIES_ENDPOINT);
    }

    public Response getProperty(String propertyId){
        setAllureRestAssured();
        return requestSpec
                .pathParam("id", propertyId)
                .get(PROPERTIES_ENDPOINT + "/{id}");
    }

    public Response postProperties(){
        Property property = PropertyDataFactory.createDefaultProperty();

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }

    public Response postPropertiesWithPropertyId(String propertyId){
        Property property = PropertyDataFactory.createDefaultProperty(propertyId);

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }

    public Response postPropertiesWithoutId(){
        Property property = PropertyDataFactory.createPropertyWithoutId();

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }

    public Response postPropertiesWithoutAlias(){
        Property property = PropertyDataFactory.createPropertyWithoutAlias();

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }

    public Response postPropertiesWithoutCountryCode(){
        Property property = PropertyDataFactory.createPropertyWithoutCountryCode();

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }

    public Response postPropertiesWithoutCreatedAt(){
        Property property = PropertyDataFactory.createPropertyWithoutCreatedAt();

        setAllureRestAssured();
        return requestSpec
                .body(property)
                .post(PROPERTIES_ENDPOINT);
    }
}
