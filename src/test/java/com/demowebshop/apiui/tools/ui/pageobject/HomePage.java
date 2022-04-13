package com.demowebshop.apiui.tools.ui.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage {
    private final SelenideElement loginLink =  $("a[href='/login']");
    private final SelenideElement emailLink =  $("a[href='/customer/info']");

    public void clickLogin(){
        loginLink
            .click();

        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
            .contains("/login");
    }

    public void userEmailIs(String email){
        emailLink
            .shouldHave(Condition.text(email));
    }
}
