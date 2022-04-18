package com.demowebshop.apiui.tools.api.listners;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomAllureListner {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");

        return FILTER;
    }
}
