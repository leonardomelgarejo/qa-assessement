package com.hostfully.svc.qa_assessment.factory;

import com.hostfully.svc.qa_assessment.model.Booking;
import com.hostfully.svc.qa_assessment.utils.DataRequests;
import com.hostfully.svc.qa_assessment.utils.StringFaker;

import java.util.UUID;

import static com.hostfully.svc.qa_assessment.enums.Status.SCHEDULED;

public class BookingDataFactory {

    public static Booking createDefaultBooking(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutId(){
        return Booking.builder()
                .id("")
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutStartDate(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate("")
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutEndDate(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate("")
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutStatus(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status("")
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutGuestFirstName(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createGuestWithoutFirstName())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutGuestLastName(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createGuestWithoutLastName())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutGuestDateOfBirth(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createGuestWithoutDateOfBirth())
                .propertyId(DataRequests.getPropertyId())
                .build()
                ;
    }

    public static Booking createBookingWithoutPropertyId(){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .startDate(StringFaker.date())
                .endDate(StringFaker.date())
                .status(SCHEDULED.getStatus())
                .guest(GuestDataFactory.createDefaultGuest())
                .propertyId("")
                .build()
                ;
    }
}
