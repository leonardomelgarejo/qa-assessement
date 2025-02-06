package com.hostfully.svc.qa_assessment.factory;

import com.hostfully.svc.qa_assessment.model.Guest;
import com.hostfully.svc.qa_assessment.utils.StringFaker;

public class GuestDataFactory {

    public static Guest createDefaultGuest(){
        return Guest.builder()
                .firstName(StringFaker.nameFaker())
                .lastName(StringFaker.lorenFaker())
                .dateOfBirth(StringFaker.date())
                .build()
                ;
    }

    public static Guest createGuestWithoutFirstName(){
        return Guest.builder()
                .firstName("")
                .lastName(StringFaker.lorenFaker())
                .dateOfBirth(StringFaker.date())
                .build()
                ;
    }

    public static Guest createGuestWithoutLastName(){
        return Guest.builder()
                .firstName(StringFaker.nameFaker())
                .lastName("")
                .dateOfBirth(StringFaker.date())
                .build()
                ;
    }

    public static Guest createGuestWithoutDateOfBirth(){
        return Guest.builder()
                .firstName(StringFaker.nameFaker())
                .lastName(StringFaker.lorenFaker())
                .dateOfBirth(null)
                .build()
                ;
    }
}
