package com.demowebshop.apiui.tools.api.helpers.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.demowebshop.apiui.tools.api.listners.CustomAllureListner.withCustomTemplates;

public class RequestSpec {

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
            .build();
    }


    public RequestSpecification postRequestSpecification() {
        return new RequestSpecBuilder()
            .addFilter(withCustomTemplates())
            .setContentType(ContentType.URLENC.withCharset("UTF-8"))
            .log(LogDetail.ALL)
            .build();
    }
}
