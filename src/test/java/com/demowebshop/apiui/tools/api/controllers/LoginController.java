package com.demowebshop.apiui.tools.api.controllers;

import com.demowebshop.apiui.tools.api.helpers.spec.RequestSpec;
import com.demowebshop.apiui.tools.api.helpers.spec.ResponseSpec;
import com.demowebshop.apiui.tools.api.models.request.LoginRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class LoginController extends BaseController {
    RequestSpec requestSpec;
    ResponseSpec responseSpec;

    public LoginController() {
        requestSpec = new RequestSpec();
        responseSpec = new ResponseSpec();
    }

    @Step("Авторизация через АПИ")
    public ValidatableResponse login(LoginRequestModel model) {
        return given()
            .spec(requestSpec.postRequestSpecification())
            .formParams(getMapParams(model))
            .post("/login")
            .then()
            .spec(responseSpec.loginResponseSpecification());
    }
}
