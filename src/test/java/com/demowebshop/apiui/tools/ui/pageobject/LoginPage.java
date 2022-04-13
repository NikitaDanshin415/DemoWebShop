package com.demowebshop.apiui.tools.ui.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://demowebshop.tricentis.com/login
public class LoginPage {
    private final SelenideElement emailInput = $("#Email");

    private final SelenideElement passwordInput = $x("//*[@id='Password']");

    private final SelenideElement loginButton = $(".login-button");

    public LoginPage fillEmail(String email){
        emailInput
            .setValue(email);

        return this;
    }

    public LoginPage fillPassword(String password){
        passwordInput
            .setValue(password);

        return this;
    }

    public void clickLogin(){
        loginButton
            .click();
    }

}