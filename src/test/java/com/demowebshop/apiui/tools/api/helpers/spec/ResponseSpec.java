package com.demowebshop.apiui.tools.api.helpers.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();
    }

    public ResponseSpecification postResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();
    }

    public ResponseSpecification loginResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectStatusCode(302)
            .log(LogDetail.ALL)
            .build();
    }
}
