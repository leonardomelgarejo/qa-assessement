package com.hostfully.svc.qa_assessment.tests;

import com.hostfully.svc.qa_assessment.client.BookingClient;
import com.hostfully.svc.qa_assessment.client.PropertyClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ContractsTests")
public class ContractsTests {

    PropertyClient propertyClient = new PropertyClient();
    BookingClient bookingClient = new BookingClient();

    @Test
    @DisplayName("Should validate the properties schema")
    public void shouldValidatePropertiesSchema(){
        propertyClient
                .getProperties()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body(JsonSchemaValidator
                                .matchesJsonSchemaInClasspath("schemas/properties.json"))
        ;
    }

    @Test
    @DisplayName("Should validate the bookings schema")
    public void shouldValidateBookingsSchema(){
        bookingClient
                .getBookings()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body(JsonSchemaValidator
                                .matchesJsonSchemaInClasspath("schemas/bookings.json"))
        ;
    }
}
