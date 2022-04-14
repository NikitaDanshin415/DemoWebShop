package com.demowebshop.apiui.tools.api.controllers;

import com.demowebshop.apiui.tools.api.helpers.spec.RequestSpec;
import com.demowebshop.apiui.tools.api.helpers.spec.ResponseSpec;
import com.demowebshop.apiui.tools.api.models.response.AddProductToCartResponseModel;
import io.restassured.http.Cookie;


import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AddProductToCartController extends BaseController {
    RequestSpec requestSpec;
    ResponseSpec responseSpec;
    String sessId;

    public AddProductToCartController() {
        requestSpec = new RequestSpec();
        responseSpec = new ResponseSpec();
    }

    public AddProductToCartController(String token) {
        requestSpec = new RequestSpec();
        responseSpec = new ResponseSpec();
        this.sessId = token;
    }

    public AddProductToCartResponseModel addBookToCart() {


        if (Objects.isNull(sessId)) {
            return given()
                .spec(requestSpec.postRequestSpecification())
                .post("/addproducttocart/catalog/13/1/1")
                .then()
                .spec(responseSpec.postResponseSpecification())
                .extract().jsonPath().getObject("", AddProductToCartResponseModel.class);
        }
        return given()
            .spec(requestSpec.postRequestSpecification())
            .cookie(getAuthCookie(sessId))
            .post("/addproducttocart/catalog/13/1/1")
            .then()
            .spec(responseSpec.postResponseSpecification())
            .extract().jsonPath().getObject("", AddProductToCartResponseModel.class);


    }

}
