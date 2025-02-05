package com.hostfully.svc.qa_assessment.tests;

import com.hostfully.svc.qa_assessment.client.BookingClient;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@DisplayName("BookingTests")
public class BookingE2ETests {

    BookingClient bookingClient = new BookingClient();

    @Test
    @DisplayName("Should list all bookings")
    public void shouldListAllBookings(){
        bookingClient
                .getBookings()
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body("", hasItems())
        ;
    }

    @Test
    @DisplayName("Should insert a booking")
    public void shouldInsertBooking(){
        bookingClient
                .postBookings()
                    .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("$", hasKey("id"))
                    .body("id", notNullValue())
                    .body("$", hasKey("startDate"))
                    .body("startDate", notNullValue())
                    .body("$", hasKey("endDate"))
                    .body("endDate", notNullValue())
                    .body("$", hasKey("status"))
                    .body("status", notNullValue())
                    .body("$", hasKey("guest"))
                    .body("guest", notNullValue())
                    .body("guest", hasKey("firstName"))
                    .body("guest.firstName", notNullValue())
                    .body("guest", hasKey("lastName"))
                    .body("guest.lastName", notNullValue())
                    .body("guest", hasKey("dateOfBirth"))
                    .body("guest.dateOfBirth", notNullValue())
                    .body("$", hasKey("propertyId"))
                    .body("propertyId", notNullValue())
        ;
    }

    @Test
    @DisplayName("Should insert a booking without id")
    @Description("When not informing the id, the system must generate an id")
    public void shouldInsertBookingWithoutId(){
        bookingClient
                .postBookingsWithoutId()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("id"))
                .body("id", notNullValue())
        ;
    }

    @Test
    @DisplayName("Should insert a booking without startDate")
    public void shouldInsertBookingWithoutStartDate(){
        bookingClient
                .postBookingsWithoutStartDate()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("errors.defaultMessage", contains("Booking start date must be supplied"))
        ;
    }

    @Test
    @DisplayName("Should insert a booking without endDate")
    public void shouldInsertBookingWithoutEndDate(){
        bookingClient
                .postBookingsWithoutEndDate()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("errors.defaultMessage", contains("Booking end date must be supplied"))
        ;
    }

    @Test
    @DisplayName("Should insert a booking without status")
    public void shouldInsertBookingWithoutStatus(){
        bookingClient
                .postBookingsWithoutStatus()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("detail", is("Failed to read request"))
        ;
    }

    @Test
    @DisplayName("Should insert a booking without guest firstName")
    public void shouldInsertBookingWithoutGuestFirstName(){
        bookingClient
                .postBookingsWithoutGuestFirstName()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("errors.defaultMessage", contains("Guest's first name cannot be empty"))
        ;
    }

    @Test
    @DisplayName("Should insert a booking without guest lastName")
    public void shouldInsertBookingWithoutGuestLastName(){
        bookingClient
                .postBookingsWithoutGuestLastName()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("errors.defaultMessage", contains("Guest's last name cannot be empty"))
        ;
    }

    @Test
    @DisplayName("Should insert a booking without guest dateOfBirth")
    @Disabled("BUG - The system does not know how to handle this scenario, the correct option would be to return status code 400 Bad Request")
    public void shouldInsertBookingWithoutGuestDateOfBirth(){
        bookingClient
                .postBookingsWithoutGuestDateOfBirth()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    @DisplayName("Should insert a booking without propertyId")
    public void shouldInsertBookingWithoutPropertyId(){
        bookingClient
                .postBookingsWithoutPropertyId()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("errors.defaultMessage", contains("Property Identifier must be supplied"))
        ;
    }

}
