package com.demowebshop.apiui.tests;

import com.demowebshop.apiui.config.app.App;
import com.demowebshop.apiui.tools.api.controllers.AddProductToCartController;
import com.demowebshop.apiui.tools.api.controllers.LoginController;
import com.demowebshop.apiui.tools.api.models.request.LoginRequestModel;
import com.demowebshop.apiui.tools.ui.helpers.BaseTest;
import com.demowebshop.apiui.tools.ui.pageobject.CartPage;
import com.demowebshop.apiui.tools.ui.pageobject.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Cookie;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

@Owner("Danshin N.P.")
public class DemoWebShopTests extends BaseTest {

    Cookie authorizationCookie;
    String bookName = "Computing and Internet";

    @Test()
    @DisplayName("Проверка удаления товара из корзины")
    @Description("")
    void addProductToFolderTest() {

        step("Авторизация через API", () -> {
            LoginRequestModel loginRequestModel =
                new LoginRequestModel(App.config.getLogin(), App.config.getPassword(), false);

            //Отправляем зарпос на авторизацию и из полученного ответа достаем токен авторизации
            ValidatableResponse loginResponse =
                new LoginController()
                    .login(loginRequestModel);

            authorizationCookie = getLoginCookie(loginResponse);
        });

        step("Открытие формы приложения и проверка успешной авторизации", () -> {
            setCookieToWebDriver(authorizationCookie);
            refresh();

            new HomePage()
                .userEmailIs(App.config.getLogin());
        });

        step("Добавление книги в корзину через API", () -> {
            new AddProductToCartController(authorizationCookie.getValue())
                .addBookToCart();
        });

        step("Проверка, что книга отображается в корзине", () -> {
            new HomePage()
                .hoverShoppingCart()
                .clickShoppingCart();

            new CartPage()
                .productsAmountIs(1)
                .cartHaveItemAmount(bookName, 1);
        });

        step("Удалить книгу из корзины", () -> {
            new CartPage()
                .removeItem(bookName)
                .clickUpdateShoppingCart()
                .productsAmountIs(0);

        });
    }
}
