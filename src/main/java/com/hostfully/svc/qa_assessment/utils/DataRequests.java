package com.hostfully.svc.qa_assessment.utils;

import com.hostfully.svc.qa_assessment.client.PropertyClient;

public class DataRequests {

    public static String getPropertyId(){
        PropertyClient propertyClient = new PropertyClient();

        int dataSize = propertyClient
                .getProperties()
                .then()
                .extract()
                .path("size()")
                ;

        if(dataSize == 0) {
            throw new RuntimeException("The property list is empty!");
        }

        String propertyId = propertyClient
                                .getProperties()
                                .then()
                                .extract()
                .path("[" + (dataSize - 1) + "].id")
                                .toString()
                            ;


        propertyClient.postPropertiesWithPropertyId(propertyId)
                .then();

        return propertyId;

        }
}
