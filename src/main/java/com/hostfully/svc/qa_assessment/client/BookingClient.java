package com.hostfully.svc.qa_assessment.client;

import com.hostfully.svc.qa_assessment.factory.BookingDataFactory;
import com.hostfully.svc.qa_assessment.model.Booking;
import io.restassured.response.Response;

public class BookingClient extends ApiClient{

    private static final String BOOKINGS_ENDPOINT = configuration.basePathBookings();

    public Response getBookings(){
        setAllureRestAssured();
        return requestSpec
                .get(BOOKINGS_ENDPOINT);
    }

    public Response postBookings(){
        Booking booking = BookingDataFactory.createDefaultBooking();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutId(){
        Booking booking = BookingDataFactory.createBookingWithoutId();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutStartDate(){
        Booking booking = BookingDataFactory.createBookingWithoutStartDate();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutEndDate(){
        Booking booking = BookingDataFactory.createBookingWithoutEndDate();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutStatus(){
        Booking booking = BookingDataFactory.createBookingWithoutStatus();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutGuestFirstName(){
        Booking booking = BookingDataFactory.createBookingWithoutGuestFirstName();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutGuestLastName(){
        Booking booking = BookingDataFactory.createBookingWithoutGuestLastName();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutGuestDateOfBirth(){
        Booking booking = BookingDataFactory.createBookingWithoutGuestDateOfBirth();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postBookingsWithoutPropertyId(){
        Booking booking = BookingDataFactory.createBookingWithoutPropertyId();

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);
    }

    public Response postWithTwoBookingsAtTheSameDay(){
       Booking booking = BookingDataFactory.createDefaultBooking();

        requestSpec.body(booking)
                        .post(BOOKINGS_ENDPOINT);

        setAllureRestAssured();
        return requestSpec
                .body(booking)
                .post(BOOKINGS_ENDPOINT);


    }
}
