package com.hostfully.svc.qa_assessment.tests;

import com.hostfully.svc.qa_assessment.BaseAPI;
import com.hostfully.svc.qa_assessment.client.PropertyClient;
import com.hostfully.svc.qa_assessment.utils.DataRequests;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@DisplayName("PropertyTests")
public class PropertyE2ETests extends BaseAPI {

    PropertyClient propertyClient = new PropertyClient();

    @Test
    @DisplayName("Should list all properties")
    public void shouldListAllProperties(){
        propertyClient
                .getProperties()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body("", hasItems())
        ;
    }

    @Test
    @DisplayName("Should return specific property")
    public void shouldReturnSpecificProperty(){
        String propertyId = DataRequests.getPropertyId();

        propertyClient
                .getProperty(propertyId)
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body("$", hasKey("id"))
                        .body("$", hasKey("id"))
                        .body("$", hasKey("alias"))
                        .body("$", hasKey("countryCode"))
                        .body("$", hasKey("createdAt"))
                        .body("id", is(propertyId))
        ;
    }

    @Test
    @DisplayName("Should not return property for non-existent id")
    public void shouldNotReturnPropertyForNonExistentId(){
        String propertyId = "144bf8ad-a434-4e9a-9a6e-f6cdc5a719ed";

        propertyClient
                .getProperty(propertyId)
                    .then()
                        .statusCode(HttpStatus.SC_NO_CONTENT)
        ;
    }

    @Test
    @DisplayName("Should not return property for inconsistent id")
    public void shouldNotReturnPropertyForInconsistentId(){
        String propertyId = "123";

        propertyClient
                .getProperty(propertyId)
                    .then()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .body("detail", is("Failed to convert 'propertyId' with value: '123'"))
        ;
    }

    @Test
    @Disabled("BUG - The countryCode entered is not being included in the insert")
    @DisplayName("Should insert a property")
    public void shouldInsertProperty(){
        propertyClient
                .postProperties()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("id"))
                        .body("id", notNullValue())
                        .body("$", hasKey("alias"))
                        .body("alias", notNullValue())
                        .body("$", hasKey("countryCode"))
                        .body("countryCode", notNullValue())
                        .body("$", hasKey("createdAt"))
                        .body("createdAt", notNullValue())
        ;
    }

    @Test
    @DisplayName("Should insert a property without id")
    @Description("When not informing the id, the system must generate an id")
    public void shouldInsertPropertyWithoutId() {
        propertyClient
                .postPropertiesWithoutId()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("id"))
                        .body("id", notNullValue())
        ;
    }

    @Test
    @DisplayName("Should not insert a property without alias")
    @Disabled("BUG - The system does not know how to handle this scenario, the correct option would be to return status code 400 Bad Request")
    public void shouldNotInsertPropertyWithoutAlias() {
        propertyClient
                .postPropertiesWithoutAlias()
                    .then()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .body("$", hasKey("alias"))
                        .body("alias", notNullValue())
        ;
    }

    @Test
    @DisplayName("Should insert a property without countryCode")
    public void shouldInsertPropertyWithoutCountry() {
        propertyClient
                .postPropertiesWithoutCountryCode()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("countryCode"))
                        .body("countryCode", nullValue())
        ;
    }

    @Test
    @DisplayName("Should not insert a property without createdAt")
    @Description("When not informing the createdAt, the system must generate an createdAt")
    public void shouldInsertPropertyWithoutCreatedAt() {
        propertyClient
                .postPropertiesWithoutCreatedAt()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("createdAt"))
                        .body("createdAt", notNullValue())
        ;
    }
}
