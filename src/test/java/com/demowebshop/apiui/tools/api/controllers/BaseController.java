package com.demowebshop.apiui.tools.api.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Cookie;

import java.util.Collections;
import java.util.Map;

public abstract class BaseController {

    protected Map<String, String> getMapParams(Object obj) {
        Map<String, String> map =
            new ObjectMapper().convertValue(obj, new TypeReference<>() {
            });
        map.values().removeAll(Collections.singleton(null));

        return map;
    }

    protected Cookie getAuthCookie(String cookieValue) {
        return new Cookie.Builder("NOPCOMMERCE.AUTH", cookieValue)
            .setSecured(true)
            .build();
    }


}
