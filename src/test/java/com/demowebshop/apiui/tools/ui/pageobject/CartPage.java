package com.demowebshop.apiui.tools.ui.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private final ElementsCollection products = $$(".cart-item-row");
    private final SelenideElement updateShoppingCartBtn = $(".update-cart-button");

    @Step("В корзине должно быть {amount} товаров")
    public CartPage productsAmountIs(int amount) {
        products
            .shouldHave(CollectionCondition.size(amount));

        return this;
    }

    @Step("Корзина должна содержать {amount} {itemName}")
    public CartPage cartHaveItemAmount(String itemName,int amount) {
        SelenideElement item  = getProductFromCart(itemName);

        item
            .find(".qty-input")
            .shouldHave(Condition.value(Integer.toString(amount)));

        return this;
    }

    @Step("Установить количество 0 у {itemName}")
    public CartPage removeItem(String itemName) {
        SelenideElement item  = getProductFromCart(itemName);

        item
            .find(".qty-input")
            .setValue("0");

        return this;
    }

    @Step("Нажать на кнопку обновления корзины")
    public CartPage clickUpdateShoppingCart() {
        updateShoppingCartBtn
            .click();

        return this;
    }

    private SelenideElement getProductFromCart(String itemName){
       return products
            .find(Condition.text(itemName));
    }
}
