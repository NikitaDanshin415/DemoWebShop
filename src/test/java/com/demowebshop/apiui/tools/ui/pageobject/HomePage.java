package com.demowebshop.apiui.tools.ui.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage {
    private final SelenideElement emailLink =  $("a[href='/customer/info']");
    private final SelenideElement shoppingCartLink =  $("#topcartlink .ico-cart");
    private final SelenideElement miniCartBlock =  $("#flyout-cart.flyout-cart");


    public HomePage userEmailIs(String email){
        emailLink
            .shouldHave(Condition.text(email));

        return this;
    }

    public HomePage hoverShoppingCart(){
        shoppingCartLink
            .hover();

        miniCartBlock
            .shouldHave(Condition.cssClass("active"));
        return this;
    }

    public HomePage clickShoppingCart(){
        shoppingCartLink
            .click();
        return this;
    }

}
