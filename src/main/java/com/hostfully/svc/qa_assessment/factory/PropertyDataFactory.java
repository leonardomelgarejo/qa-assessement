package com.hostfully.svc.qa_assessment.factory;

import com.hostfully.svc.qa_assessment.enums.CountryCode;
import com.hostfully.svc.qa_assessment.model.Property;
import com.hostfully.svc.qa_assessment.utils.StringFaker;

import java.util.UUID;

public class PropertyDataFactory {

    public static Property createDefaultProperty(){
        return Property.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .alias(StringFaker.aliasFaker())
                .countryCode(CountryCode.US.getCode())
                .createdAt(StringFaker.dateTimeFaker())
                .build()
                ;
    }

    public static Property createDefaultProperty(String propertyId){
        return Property.builder()
                .id(propertyId)
                .alias(StringFaker.aliasFaker())
                .countryCode(CountryCode.US.getCode())
                .createdAt(StringFaker.dateTimeFaker())
                .build()
                ;
    }

    public static Property createPropertyWithoutId(){
        return Property.builder()
                .id("")
                .alias(StringFaker.aliasFaker())
                .countryCode(CountryCode.US.getCode())
                .createdAt(StringFaker.dateTimeFaker())
                .build()
                ;
    }

    public static Property createPropertyWithoutAlias(){
        return Property.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .alias("")
                .countryCode(CountryCode.US.getCode())
                .createdAt(StringFaker.dateTimeFaker())
                .build()
                ;
    }

    public static Property createPropertyWithoutCountryCode(){
        return Property.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .alias(StringFaker.aliasFaker())
                .countryCode(CountryCode.US.getCode())
                .createdAt(StringFaker.dateTimeFaker())
                .build()
                ;
    }

    public static Property createPropertyWithoutCreatedAt(){
        return Property.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .alias(StringFaker.aliasFaker())
                .countryCode(CountryCode.US.getCode())
                .createdAt("")
                .build()
                ;
    }
}
