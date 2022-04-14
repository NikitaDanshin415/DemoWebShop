package com.demowebshop.apiui.tools.ui.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class HomePage {
    private final SelenideElement emailLink =  $("a[href='/customer/info']");
    private final SelenideElement shoppingCartLink =  $("#topcartlink .ico-cart");
    private final SelenideElement miniCartBlock =  $("#flyout-cart.flyout-cart");


    @Step("Логин пользователя должен быть равен {email}")
    public HomePage userEmailIs(String email){
        emailLink
            .shouldHave(Condition.text(email));

        return this;
    }

    @Step("Навестись на ссылку корзины")
    public HomePage hoverShoppingCart(){
        shoppingCartLink
            .hover();

        miniCartBlock
            .shouldHave(Condition.cssClass("active"));
        return this;
    }

    @Step("Нажать на ссылку корзины")
    public HomePage clickShoppingCart(){
        shoppingCartLink
            .click();
        return this;
    }

}
