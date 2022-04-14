package com.demowebshop.apiui.tools.api.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginRequestModel {
    public LoginRequestModel(String email, String password, Boolean rememberMe) {
        this.email = email;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    @JsonProperty("Email")
    String email;
    @JsonProperty("Password")
    String password;
    @JsonProperty("RememberMe")
    Boolean rememberMe;
}
