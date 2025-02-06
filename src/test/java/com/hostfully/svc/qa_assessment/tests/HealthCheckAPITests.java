package com.hostfully.svc.qa_assessment.tests;

import com.hostfully.svc.qa_assessment.BaseAPI;
import com.hostfully.svc.qa_assessment.client.BookingClient;
import com.hostfully.svc.qa_assessment.client.PropertyClient;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("HealthcheckTest")
public class HealthCheckAPITests extends BaseAPI {

    PropertyClient propertyClient = new PropertyClient();
    BookingClient bookingClient = new BookingClient();

    @Test
    @DisplayName("Should connect the properties resource")
    public void shouldConnectQAAssessmentApiProperties(){
        propertyClient
                .getProperties()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    @DisplayName("Should connect the bookings resource")
    public void shouldConnectQAAssessmentApiBookings(){
        bookingClient
                .getBookings()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
        ;
    }
}
