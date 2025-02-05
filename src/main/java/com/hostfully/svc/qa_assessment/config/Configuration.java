package com.hostfully.svc.qa_assessment.config;

import io.restassured.http.ContentType;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:api.properties"
})
public interface Configuration extends Config{

    @Key("api.base.uri")
    String baseURI();

    @Key("content.type")
    ContentType contentType();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("base.path.properties")
    String basePathProperties();

    @Key("base.path.bookings")
    String basePathBookings();

}