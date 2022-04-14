package com.demowebshop.apiui.tools.api.helpers.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
            .build();
    }


    public RequestSpecification postRequestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.URLENC.withCharset("UTF-8"))
            .log(LogDetail.ALL)
            .build();
    }
}
