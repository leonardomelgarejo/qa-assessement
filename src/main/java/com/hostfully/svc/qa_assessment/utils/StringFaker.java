package com.hostfully.svc.qa_assessment.utils;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class StringFaker {

    public static String nameFaker(){
        Faker faker = new Faker();
        return faker.artist().name();
    }

    public static String lorenFaker(){
        Faker faker = new Faker();
        return faker.lorem().fixedString(10);
    }
    public static String aliasFaker(){
        Faker faker = new Faker();
        return "Apartament on " + faker.address().streetName() + " " + faker.address().state();
    }

    public static String dateTimeFaker(){
        Instant now = Instant.now();

        return DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .withZone(ZoneOffset.UTC)
            .format(now);
    }

    public static String date(){
        Instant now = Instant.now();

        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd")
                .withZone(ZoneOffset.UTC)
                .format(now);
    }
}
